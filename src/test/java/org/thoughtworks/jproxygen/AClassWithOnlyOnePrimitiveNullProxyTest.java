package org.thoughtworks.jproxygen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 6:23:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AClassWithOnlyOnePrimitiveNullProxyTest {
    @Test
    public void shouldReturnSameValueWhenNoBehaviorOverridden() {
        AClassWithOnlyOnePrimitiveCallbackProxy proxy = new AClassWithOnlyOnePrimitiveCallbackProxy(new NoOverrideCallback());
        proxy.setIntValue(12);
        assertEquals(12, proxy.getIntValue());
    }

    @Test
    public void shouldReturnNegatedValueWhenSetBehaviorOverridden() {
        AClassWithOnlyOnePrimitiveCallbackProxy proxy = new AClassWithOnlyOnePrimitiveCallbackProxy(new NegateOnSetCallback());
        proxy.setIntValue(12);
        assertEquals(-12, proxy.getIntValue());
    }

    @Test
    public void shouldReturnSameNegatedValueMultipleTimesWhenSetOverridden() {
        AClassWithOnlyOnePrimitiveCallbackProxy proxy = new AClassWithOnlyOnePrimitiveCallbackProxy(new NegateOnSetCallback());
        proxy.setIntValue(12);
        assertEquals(-12, proxy.getIntValue());
        assertEquals(-12, proxy.getIntValue());
    }

    @Test
    public void shouldDecrementValueWhenGetOverridden() {
        AClassWithOnlyOnePrimitiveCallbackProxy proxy = new AClassWithOnlyOnePrimitiveCallbackProxy(new DecrementOnGetCallback());
        proxy.setIntValue(12);
        assertEquals(12, proxy.getIntValue());
        assertEquals(11, proxy.getIntValue());
    }

}
