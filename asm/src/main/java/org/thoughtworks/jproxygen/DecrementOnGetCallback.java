package org.thoughtworks.jproxygen;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 8:15:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecrementOnGetCallback implements JProxyCallback {
    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        if (Timing.POST.equals(timing) && "getIntValue".equals(methodName)) {
                if (methodArgs.length > 0) {
                    Object first = methodArgs[0];
                Integer value = ((Integer) first) - 1;
                ((AClassWithOnlyOnePrimitive)proxiedObject).setIntValue(value);
            }

        }
        return JProxyCallback.Behavior.DEFAULT;
    }
}
