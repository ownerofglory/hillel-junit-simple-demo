package ua.ithillel.junit.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SimpleCalculatorTest {
    private SimpleCalculator simpleCalculator;

    @BeforeAll
    public static void setAppClass() {
        System.out.println("Setting up the test class");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up the test");
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void addTest_success() {
        double a = 10;
        double b = 5;

        double expectedValue = 15;

        double actualValue = simpleCalculator.add(a, b);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void subtractTest_success() {
        double a = 10;
        double b = 5;

        double expectedValue = 5;

        double actualValue = simpleCalculator.subtract(a, b);


        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void multiplyTest_success() {
        double a = 10;
        double b = 5;

        double expectedValue = 50;

        double actualValue = simpleCalculator.multiply(a, b);


        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void divideTest_success() throws CalculatorException {
        double a = 10;
        double b = 5;

        double expectedValue = 2;

        double actualValue = simpleCalculator.divide(a, b);


        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void divideTest_throwsException() {
        double a = 10;
        double b = 0; // required

        assertThrows(CalculatorException.class, () -> {
            simpleCalculator.divide(a, b);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tear down test");
        simpleCalculator = null;
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tests finished");
    }
}
