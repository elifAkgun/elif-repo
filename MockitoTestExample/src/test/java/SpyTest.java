import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void testMock() {
        List arrayListMock = mock(ArrayList.class);
        assertEquals(0, arrayListMock.size());
        arrayListMock.add("Elif");
        assertEquals(0, arrayListMock.size());
    }

    @Test
    public void testSpy() {
        List arrayListMock = spy(ArrayList.class);
        arrayListMock.add("Elif");
        verify(arrayListMock).add("Elif");
    }
}
