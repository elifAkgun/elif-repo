package code.elif.powermock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SystemUnderTestPowerMockTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void methodCallingAStaticMethod() {

        List<Integer> stats = Arrays.asList(1, 2, 3);
        when(dependency.retrieveAllStats()).thenReturn(stats);

        try (MockedStatic<UtilityClassStatic> mockedStatic = Mockito.mockStatic(UtilityClassStatic.class)) {
            mockedStatic.when(() -> UtilityClassStatic.staticMethod(1 + 2 + 3)).thenReturn(150);
            assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
            mockedStatic.verify(() -> UtilityClassStatic.staticMethod(6));
        }


    }
}