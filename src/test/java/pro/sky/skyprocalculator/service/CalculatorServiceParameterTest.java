package pro.sky.skyprocalculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.skyprocalculator.exceptions.DivideByZeroException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParameterTest {
    CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("provideParamsForAdding")
    void addingTest(int num1, int num2, int expected) {
        int actual = calculatorService.adding(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideParamsForAdding() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 5, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSubtracting")
    void subtractingTest(int num1, int num2, int expected) {
        int actual = calculatorService.subtracting(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideParamsForSubtracting() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-1, 5, -6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplying")
    void multiplyingTest(int num1, int num2, int expected) {
        int actual = calculatorService.multiplying(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideParamsForMultiplying() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-1, 5, -5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDividing")
    void dividingTest(int num1, int num2, int expected) {
        int actual = calculatorService.dividing(num1, num2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideParamsForDividing() {
        return Stream.of(
                Arguments.of(1, 2, 0),
                Arguments.of(10, 5, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDividingException")
    void dividingThrowsDivideByZeroExceptionTest(int num1, int num2) {
        assertThrows(DivideByZeroException.class, () -> calculatorService.dividing(num1, num2));
    }

    static Stream<Arguments> provideParamsForDividingException() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(10, 0)
        );
    }
}