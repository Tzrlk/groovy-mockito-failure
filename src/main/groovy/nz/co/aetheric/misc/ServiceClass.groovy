package nz.co.aetheric.misc

import groovy.transform.CompileStatic

/**
 * This class exists solely to be mocked out when testing {@link TargetClass#callServiceMethod}.
 * @author Peter Cummuskey (http://gplus.to/tzrlk)
 */
@CompileStatic
public class ServiceClass {

    /**
     * This method should never be called, except when the 'service' is mocked out. Will throw an exception if ever
     * actually evaluated.
     * @param param The param to pass into the method.
     * @return An irrelevant boolean value.
     */
    public boolean serviceMethod(Map param) {
        throw new Exception("Either you forgot to mock this method, or something went wrong with the mocking that " +
                "you did. You should probably get that checked.");
    }

}
