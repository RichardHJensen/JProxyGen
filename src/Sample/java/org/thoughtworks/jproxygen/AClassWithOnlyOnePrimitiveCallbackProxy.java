package org.thoughtworks.jproxygen;

import static org.thoughtworks.jproxygen.JProxyCallback.Behavior;
import static org.thoughtworks.jproxygen.JProxyCallback.Timing;

public class AClassWithOnlyOnePrimitiveCallbackProxy extends AClassWithOnlyOnePrimitive {
    private JProxyCallback callback;

    public AClassWithOnlyOnePrimitiveCallbackProxy(JProxyCallback callback) {

        this.callback = callback;
    }

    @Override
    public int getIntValue() {
        int value = 0;
        Object result = callback.invoke(this, Timing.PRE, "getIntValue");
        if (Behavior.DEFAULT == result) {
           value = super.getIntValue();
        }
        result = callback.invoke(this, Timing.POST, "getIntValue", value);
        if (Behavior.DEFAULT != result && (Behavior.BYPASS != result)) {
            value = (Integer) result;
        }
        return (Integer) value;
    }

    @Override
    public void setIntValue(int intValue) {
        Object result = callback.invoke(this, Timing.PRE, "setIntValue",  intValue);
        if (Behavior.DEFAULT == result) {
            super.setIntValue(intValue);
        }
        else if (Behavior.BYPASS != result) {
            super.setIntValue((Integer) result);
        }
        callback.invoke(this, Timing.POST, "setIntValue", intValue);
    }
}
