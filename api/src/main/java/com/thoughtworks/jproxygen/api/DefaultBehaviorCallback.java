package com.thoughtworks.jproxygen.api;

public class DefaultBehaviorCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        return JProxyCallback.Behavior.DEFAULT;
    }
}
