package org.thoughtworks.jproxygen;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 7:48:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JProxyCallback {
    enum Timing { PRE, POST };
    Object DEFAULT_BEHAVIOR = new Object();
    Object BYPASS_BEHAVIOR = new Object();
    Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs);
}
