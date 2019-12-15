package pl.programator;

import org.junit.*;

public class CalculatorTest {

    public static Calculator calculator;

    public CalculatorTest() {
        System.out.println("Konstruktor !!");
    }

    @Before
    public void prepareTestObjects() {
        System.out.println("Before !!!");
    }

    @BeforeClass
    public static void prepareTestObjects2() {
        System.out.println("Before Class !!!");
        CalculatorTest.calculator = new Calculator();
    }

    @After
    public void after() {
        System.out.println("After !!");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass !!");
    }

    @Test
    public void sumTest() {
        int a = 5;
        int b = 6;
        int expectedResult = 11;

        int result = CalculatorTest.calculator.sum(a, b);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void divideTest() {
        int a = 5;
        int b = 2;
        double expectedResult = 2.5;

        double result = CalculatorTest.calculator.divide(a, b);

        Assert.assertEquals(expectedResult, result, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroTest() {
        int a = 5;
        int b = 0;

        CalculatorTest.calculator.divide(a, b);
    }
}
