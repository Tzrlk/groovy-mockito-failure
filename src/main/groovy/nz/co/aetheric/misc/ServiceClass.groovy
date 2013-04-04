package nz.co.aetheric.misc

import groovy.transform.CompileStatic

/**
 * This class exists solely to be mocked out when testing {@link TargetClass#callServiceMethod}.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@CompileStatic
public class ServiceClass {

    /**
     * This method should never be called, except when the 'service' is mocked out. Will throw an exception if ever
     * actually evaluated.
     * @return An irrelevant boolean value.
     */
    public String serviceMethod(String string, Map map = [:]) {
        throw new Exception("Either you forgot to mock this method, or something went wrong with the mocking that " +
                "you did. You should probably get that checked.");
    }

}
