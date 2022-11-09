package code.elif.junit.sample;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAlL executes only once before all test methods execution in the class\n");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }

    @BeforeEach
    void setupBeforeEach() {
        // set up
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("@AfterEach executes before the execution of each test method");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void test_EqualsAndNotEquals() {
        // execute and assert
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(1, 9), "1 +9 must not be 8");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test_NullAndNotNull() {
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSameAndNotSame() {
        String str = "Jack";
        assertSame(demoUtils.getName(), demoUtils.getNameDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getName(), "Objects should not refer same object");
    }

    @DisplayName("True and False")
    @Test
    @EnabledOnOs(OS.MAC)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(),
                "Arrays should be the same");
    }


    @DisplayName("Iterator Equals")
    @Test
    void getNameInList() {
        List<String> fruitsInList = List.of("apple", "peach", "orange");
        assertIterableEquals(fruitsInList, demoUtils.getFruitsInList());
    }

    @DisplayName("Line matches")
    @Test
    void getStringInList() {
        List<String> fruitsInList = List.of("apple", "peach", "orange");
        assertLinesMatch(fruitsInList, demoUtils.getFruitsInList());
    }

    @DisplayName("Throw exception matches")
    @Test
    void throwException() {
        String message = assertThrows(Exception.class,
                () -> demoUtils.throwException(-1)).getMessage();
        assertEquals("Value s'ould be greater than or equal to 0", message);

    }

    @DisplayName("Throw exception matches")
    @Test
    void timeOutPreemptively() {
        assertTimeoutPreemptively(Duration.ofSeconds(3),
                () -> demoUtils.getFruitsInList(),
                "Method should execute in 3 seconds ");
    }
}
