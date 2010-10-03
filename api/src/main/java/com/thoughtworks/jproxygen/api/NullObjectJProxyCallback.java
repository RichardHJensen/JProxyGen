package com.thoughtworks.jproxygen.api;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 22, 2010
 * Time: 6:32:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class NullObjectJProxyCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        return JProxyCallback.Behavior.BYPASS;
    }
}
