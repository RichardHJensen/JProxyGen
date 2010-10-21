package com.thoughtworks.jproxygen.asm;

import com.thoughtworks.jproxygen.api.DefaultBehaviorCallback;
import com.thoughtworks.jproxygen.api.JProxyCallback;
import com.thoughtworks.jproxygen.api.NullObjectJProxyCallback;
import com.thoughtworks.jproxygen.sample.AClassWithOnlyOnePrimitive;
import org.junit.Test;

import static com.thoughtworks.jproxygen.api.JProxyCallback.Behavior;
import static com.thoughtworks.jproxygen.api.JProxyCallback.Timing.POST;
import static com.thoughtworks.jproxygen.api.JProxyCallback.Timing.PRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AClassWithOnlyOnePrimitiveProxyTest {

    private JProxyCallback cb = mock(JProxyCallback.class);

    @Test
    public void shouldReturnSameValueWhenNoBehaviorOverridden() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new DefaultBehaviorCallback());
        proxy.setIntValue(12);
        assertEquals(12, proxy.getIntValue());
    }

    @Test
    public void shouldReturnNegatedValueWhenSetBehaviorOverridden() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new NegateOnSetCallback());
        proxy.setIntValue(12);
        assertEquals(-12, proxy.getIntValue());
    }

    @Test
    public void shouldReturnSameOverriddenValueMultipleTimesWhenSetOverridden() {
        AClassWithOnlyOnePrimitive.PROXY proxy = new AClassWithOnlyOnePrimitive.PROXY(cb);
        replaceOriginalWithOverride(proxy, 12, -14);
        proxy.setIntValue(12);
        assertEquals(-14, proxy.getIntValue());
    }

    private void replaceOriginalWithOverride(AClassWithOnlyOnePrimitive.PROXY proxy, final int orig, final int ovr) {
        when(cb.invoke(proxy, PRE, "setIntValue", orig)).thenReturn(Behavior.DEFAULT);
        when(cb.invoke(proxy, POST, "getIntValue", 0)).thenReturn(ovr);
    }

    @Test
    public void shouldReturnSameOverriddenValueMultipleTimesWhenSetOverridden2() {
        AClassWithOnlyOnePrimitive.PROXY proxy = new AClassWithOnlyOnePrimitive.PROXY(cb);
        replaceOriginalWithOverride(proxy, 12, -14);
        proxy.setIntValue(12);
        assertEquals(-14, proxy.getIntValue());
        assertEquals(-14, proxy.getIntValue());
    }

    @Test
    public void shouldDecrementValueWhenGetOverridden() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new DecrementOnGetCallback());
        proxy.setIntValue(12);
        assertEquals(12, proxy.getIntValue());
        assertEquals(11, proxy.getIntValue());
    }

    @Test
    public void shouldReturnBaseValueWhenNullProxy() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new NullObjectJProxyCallback());
        proxy.setIntValue(12);
        assertEquals(0, proxy.getIntValue());
    }

    @Test
    public void shouldReturnBaseValueWhenNoValueSetForNullProxy() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new NullObjectJProxyCallback());
        assertEquals(0, proxy.getIntValue());
    }

    @Test
    public void shouldInstrumentSettingValueWithOutputStreamProxy() {
        OutputStreamProxyCallback outputStreamProxyCallback = new OutputStreamProxyCallback();
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(outputStreamProxyCallback);
        proxy.setIntValue(1);
        proxy.getIntValue();
        assertEquals("111", outputStreamProxyCallback.resultBuilder.toString());

    }

    private class OutputStreamProxyCallback implements JProxyCallback {
        public StringBuilder resultBuilder = new StringBuilder();

        public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
            if (methodArgs.length > 0) {
                resultBuilder.append(methodArgs[0]);
            }
            return Behavior.DEFAULT;
        }
    }

    @Test
    public void enumsShouldEqualWithDoubleEqual() {
        assertTrue(Behavior.BYPASS == Behavior.BYPASS);
    }

    @Test
    public void shouldCallPostEvenWhenBypassingBehaviorInCallback() {
        MethodInvocationTraceCallback callback = new MethodInvocationTraceCallback();
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(callback);
        proxy.setIntValue(13);
        assertTrue(callback.resultBuilder.indexOf("POST-setIntValue") >= 0);
    }

    private class MethodInvocationTraceCallback implements JProxyCallback {
        public StringBuilder resultBuilder = new StringBuilder();
        public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
            resultBuilder.append(timing + "-" + methodName + "\n");
            return Behavior.BYPASS;
        }
    }
}
