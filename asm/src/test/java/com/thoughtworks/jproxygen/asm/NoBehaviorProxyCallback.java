package com.thoughtworks.jproxygen.asm;

import com.thoughtworks.jproxygen.api.JProxyCallback;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 22, 2010
 * Time: 6:32:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoBehaviorProxyCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        return JProxyCallback.Behavior.BYPASS;
    }
}