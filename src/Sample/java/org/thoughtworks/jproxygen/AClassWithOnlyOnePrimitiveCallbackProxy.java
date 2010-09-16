package org.thoughtworks.jproxygen;

import static org.thoughtworks.jproxygen.JProxyCallback.Timing.POST;
import static org.thoughtworks.jproxygen.JProxyCallback.Timing.PRE;


public class AClassWithOnlyOnePrimitiveCallbackProxy extends AClassWithOnlyOnePrimitive {
    private JProxyCallback callback;

    public AClassWithOnlyOnePrimitiveCallbackProxy(JProxyCallback callback) {

        this.callback = callback;
    }

    @Override
    public int getIntValue() {
        int value = 0;
        Object result = callback.invoke(this, PRE, "getIntValue");
        if (null == result) {
           value = super.getIntValue();
        }
        result = callback.invoke(this, POST, "getIntValue", value);
        if (null != result) {
            value = (Integer) result;
        }
        return (Integer) value;
    }

    @Override
    public void setIntValue(int intValue) {
        Object result = callback.invoke(this, PRE, "setIntValue",  intValue);
        if (null == result) {
            super.setIntValue(intValue);
         }
        else {
            super.setIntValue((Integer) result);
        }
        callback.invoke(this, POST, "setIntValue", intValue);
    }
}
