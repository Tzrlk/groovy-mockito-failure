package nz.co.aetheric.misc

import groovy.transform.CompileStatic

/**
 * This class has one method that calls a method on the service class. It's only function is to be tested.
 * @author Peter Cummuskey (http://gplus.to/tzrlk)
 */
@CompileStatic
public class TargetClass {

    /**
     * This field would normally be injected by spring or something.
     */
    ServiceClass serviceClass;

    /**
     * Proxies the call directly to {@link ServiceClass#serviceMethod}.
     * @param param A parameter to pass on to the service method.
     */
    public boolean callServiceMethod(Map param) {
        return serviceClass.serviceMethod(param);
    }

}
