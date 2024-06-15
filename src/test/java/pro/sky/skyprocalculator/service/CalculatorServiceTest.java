package pro.sky.skyprocalculator.service;

import org.junit.jupiter.api.Test;
import pro.sky.skyprocalculator.exceptions.DivideByZeroException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();


    @Test
    void addingTest() {
        int num1 = 1;
        int num2 = 2;
        int expected = 3;

        int actual = calculatorService.adding(num1, num2);

        assertEquals(expected, actual);

        num1 = -1;
        num2 = 5;
        expected = 4;

        actual = calculatorService.adding(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    void subtractingTest() {
        int num1 = 1;
        int num2 = 2;
        int expected = -1;

        int actual = calculatorService.subtracting(num1, num2);

        assertEquals(expected, actual);

        num1 = -1;
        num2 = 5;
        expected = -6;

        actual = calculatorService.subtracting(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    void multiplyingTest() {
        int num1 = 1;
        int num2 = 2;
        int expected = 2;

        int actual = calculatorService.multiplying(num1, num2);

        assertEquals(expected, actual);

        num1 = -1;
        num2 = 5;
        expected = -5;

        actual = calculatorService.multiplying(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    void dividingTest() {
        int num1 = 1;
        int num2 = 2;
        int expected = 0;

        int actual = calculatorService.dividing(num1, num2);

        assertEquals(expected, actual);

        num1 = 10;
        num2 = 5;
        expected = 2;

        actual = calculatorService.dividing(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    void dividingThrowsDivideByZeroExceptionTest() {
        int num1 = 1;
        int num2 = 0;

        assertThrows(DivideByZeroException.class, () -> calculatorService.dividing(num1, num2));
    }
}






