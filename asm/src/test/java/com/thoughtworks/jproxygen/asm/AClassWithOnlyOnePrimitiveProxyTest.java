package com.thoughtworks.jproxygen.asm;

import com.thoughtworks.jproxygen.api.JProxyCallback;
import com.thoughtworks.jproxygen.api.NullObjectJProxyCallback;
import com.thoughtworks.jproxygen.sample.AClassWithOnlyOnePrimitive;
import org.junit.Test;

import static com.thoughtworks.jproxygen.api.JProxyCallback.Behavior;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 6:23:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AClassWithOnlyOnePrimitiveProxyTest {
    @Test
    public void shouldReturnSameValueWhenNoBehaviorOverridden() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new NoOverrideCallback());
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
    public void shouldReturnSameNegatedValueMultipleTimesWhenSetOverridden() {
        AClassWithOnlyOnePrimitive proxy = new AClassWithOnlyOnePrimitive.PROXY(new NegateOnSetCallback());
        proxy.setIntValue(12);
        assertEquals(-12, proxy.getIntValue());
        assertEquals(-12, proxy.getIntValue());
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
