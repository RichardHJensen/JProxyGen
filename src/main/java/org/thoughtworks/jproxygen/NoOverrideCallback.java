package org.thoughtworks.jproxygen;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 7:47:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoOverrideCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
