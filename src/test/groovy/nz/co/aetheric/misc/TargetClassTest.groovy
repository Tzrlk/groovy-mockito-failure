package nz.co.aetheric.misc

import groovy.transform.CompileStatic
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException
import org.mockito.runners.MockitoJUnitRunner

import static org.mockito.Matchers.anyMap
import static org.mockito.Matchers.anyString
import static org.mockito.Mockito.*

/**
 * This set of tests should fail to illustrate an issue with Mockito matchers in a groovy environment.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
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
        when(serviceClass.serviceMethod(TargetClass.string, TargetClass.map)).thenReturn("");

        // these should evaluate just fine.
        targetClass.callServiceMethod();

        verify(serviceClass, times(1)).serviceMethod(TargetClass.string, TargetClass.map);
        verify(serviceClass, never()).serviceMethod(TargetClass.string);
    }

    @Test(expected = InvalidUseOfMatchersException)
    public void "Fails horribly when I do use matchers"() throws Exception {
        when(serviceClass.serviceMethod(anyString(), anyMap())).thenReturn("");

        targetClass.callServiceMethod();
    }

}
