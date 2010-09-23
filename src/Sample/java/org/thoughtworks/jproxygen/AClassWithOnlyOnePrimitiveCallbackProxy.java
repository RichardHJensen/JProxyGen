package org.thoughtworks.jproxygen;

import static org.thoughtworks.jproxygen.JProxyCallback.BYPASS_BEHAVIOR;
import static org.thoughtworks.jproxygen.JProxyCallback.DEFAULT_BEHAVIOR;
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
        if (DEFAULT_BEHAVIOR == result) {
           value = super.getIntValue();
        }
        result = callback.invoke(this, POST, "getIntValue", value);
        if (DEFAULT_BEHAVIOR != result && (BYPASS_BEHAVIOR != result)) {
            value = (Integer) result;
        }
        return (Integer) value;
    }

    @Override
    public void setIntValue(int intValue) {
        Object result = callback.invoke(this, PRE, "setIntValue",  intValue);
        if (DEFAULT_BEHAVIOR == result) {
            super.setIntValue(intValue);
        }
        else if (BYPASS_BEHAVIOR == result) {
            return;
        }
        else {
            super.setIntValue((Integer) result);
        }
        callback.invoke(this, POST, "setIntValue", intValue);
    }
}
