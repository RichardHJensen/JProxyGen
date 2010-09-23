package org.thoughtworks.jproxygen;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 15, 2010
 * Time: 6:32:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NegateOnSetCallback implements JProxyCallback {

    public Object invoke(Object proxiedObject, Timing timing, String methodName, Object... methodArgs) {
        if (Timing.PRE.equals(timing) && "setIntValue".equals(methodName)) {
            if (methodArgs.length > 0) {
                Object first = methodArgs[0];
//                System.out.printf("%s:(%s)\n", first.getClass().getName(), first.toString());
                Integer value = (Integer) first;
                return value * -1;
            }

        }
        return JProxyCallback.DEFAULT_BEHAVIOR;
    }
}
