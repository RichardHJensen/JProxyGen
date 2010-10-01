package com.thoughtworks.jproxygen.asm;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 7:47:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoOverrideCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        return JProxyCallback.Behavior.DEFAULT;
    }
}
