package nz.co.aetheric.misc
import groovy.transform.CompileStatic
/**
 * This class has one method that calls a method on the service class. It's only function is to be tested.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@CompileStatic
public class TargetClass {

    public static final String string = "This is a string";
    public static final Map map = [ key: "value" ];

    /**
     * This field would normally be injected by spring or something.
     */
    ServiceClass serviceClass;

    /**
     * Proxies the call directly to {@link ServiceClass#serviceMethod}.
     * @param param A parameter to pass on to the service method.
     */
    public void callServiceMethod() {
        serviceClass.serviceMethod(string, map);
    }

}
