package code.elif.junit.sample;

import code.elif.DemoUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeAll
    public static void setupBeforeEachClass() {
        System.out.println("@BeforeAlL executes only once before all test methods execution in the class\n");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }

    @BeforeEach
    public void setupBeforeEach() {
        // set up
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("@AfterEach executes before the execution of each test method");
    }

    @Test
    public void test_EqualsAndNotEquals() {
        // execute and assert
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(1, 9), "1 +9 must not be 8");
    }

    @Test
    public void test_NullAndNotNull() {
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Test
    public void testSameAndNotSame() {
        String str = "Jack";
        assertSame(demoUtils.getName(), demoUtils.getNameDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getName(), "Objects should not refer same object");
    }

    @DisplayName("True and False")
    @Test
    public void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    public void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(),
                "Arrays should be the same");
    }
}
