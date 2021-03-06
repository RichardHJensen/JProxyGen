package com.thoughtworks.jproxygen.api;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 7:48:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JProxyCallback {
    enum Timing { PRE, POST };
    enum Behavior { DEFAULT, BYPASS };
    Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs);
}
