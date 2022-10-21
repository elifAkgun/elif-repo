package code.elif.junit.sample;

import code.elif.DemoUtils;
import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
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
    void test_EqualsAndNotEquals() {
        // execute and assert
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(1, 9), "1 +9 must not be 8");
    }

    @Test
    void test_NullAndNotNull() {
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "Jack";
        assertSame(demoUtils.getName(), demoUtils.getNameDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getName(), "Objects should not refer same object");
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }
}
