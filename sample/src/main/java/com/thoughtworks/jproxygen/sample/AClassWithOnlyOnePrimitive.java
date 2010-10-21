package com.thoughtworks.jproxygen.sample;

import com.thoughtworks.jproxygen.api.JProxyCallback;
import com.thoughtworks.jproxygen.api.NullObjectJProxyCallback;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 7:55:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class AClassWithOnlyOnePrimitive {

    protected int intValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    // These two static-inner classes are what we hope to generate

    public static class PROXY extends AClassWithOnlyOnePrimitive {

        private JProxyCallback callback;

        public PROXY(JProxyCallback callback) {
            this.callback = callback;
        }

        @Override
        public int getIntValue() {
            int value = 0;
            Object result = callback.invoke(this, JProxyCallback.Timing.PRE, "getIntValue");
            if (JProxyCallback.Behavior.DEFAULT == result) {
                value = super.getIntValue();
            }
            result = callback.invoke(this, JProxyCallback.Timing.POST, "getIntValue", value);
            if (JProxyCallback.Behavior.DEFAULT != result && JProxyCallback.Behavior.BYPASS != result) {
                value = (Integer) result;
            }
            return (Integer) value;
        }

        @Override
        public void setIntValue(int intValue) {
            Object result = callback.invoke(this, JProxyCallback.Timing.PRE, "setIntValue", intValue);
            if (JProxyCallback.Behavior.DEFAULT == result) {
                super.setIntValue(intValue);
            } else if (JProxyCallback.Behavior.BYPASS != result) {
                super.setIntValue((Integer) result);
            }
            callback.invoke(this, JProxyCallback.Timing.POST, "setIntValue", intValue);
        }
    }

    public static class NULL extends AClassWithOnlyOnePrimitive.PROXY {

        public NULL() {
            super(new NullObjectJProxyCallback());
        }
    }


}
