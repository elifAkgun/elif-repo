package code.elif;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberOfIsland.class)
public class NumberOfIslandTest {

    @Test
    public void numIslands() {
        PowerMockito.mockStatic(NumberOfIsland.class);

        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        when(NumberOfIsland.numIslands(input)).thenReturn(1);

    }
}