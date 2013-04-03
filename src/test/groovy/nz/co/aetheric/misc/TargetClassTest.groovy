package nz.co.aetheric.misc

import groovy.transform.CompileStatic
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.exceptions.base.MockitoException
import org.mockito.runners.MockitoJUnitRunner

import static org.mockito.Matchers.anyMap
import static org.mockito.Mockito.*

/**
 * This set of tests should fail to illustrate an issue with Mockito matchers in a groovy environment.
 * @author Peter Cummuskey (http://gplus.to/tzrlk)
 */
@CompileStatic
@RunWith(MockitoJUnitRunner)
public class TargetClassTest {

    @InjectMocks
    TargetClass targetClass;

    @Mock
    ServiceClass serviceClass;

    @Test
    public void "Works fine when I don't use matchers"() throws Exception {
        Map param = [:];

        when(serviceClass.serviceMethod(param)).thenReturn(true);

        // these should evaluate just fine.
        assert targetClass.callServiceMethod(param);
        verify(serviceClass, times(1)).serviceMethod(param);
    }

    @Test(expected = MockitoException)
    public void "Fails horribly when I do use matchers"() throws Exception {
        Map param = [:];

        // should throw an exception here.
        when(serviceClass.serviceMethod(anyMap())).thenReturn(true);

        // will never reach this step
        assert targetClass.callServiceMethod(param);
        verify(serviceClass, times(1)).serviceMethod(anyMap());
    }

}
