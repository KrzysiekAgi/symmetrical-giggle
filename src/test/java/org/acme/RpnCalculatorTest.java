package org.acme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RpnCalculatorTest {

    private RpnCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new RpnCalculator();
    }

    @Test
    void testMultiplicationAndAddition() {
        assertEquals(16, calculator.evaluateRpn(List.of("2", "4", "*", "8", "+")));
    }

    @Test
    void testAdditionAndMultiplication() {
        assertEquals(24, calculator.evaluateRpn(List.of("2", "4", "8", "+", "*")));
    }

    @Test
    void testDivisionMultiplicationAndAddition() {
        assertEquals(7, calculator.evaluateRpn(List.of("8", "4", "/", "3", "*", "1", "+")));
    }

    @Test
    void testDivisionAndAddition() {
        assertEquals(6, calculator.evaluateRpn(List.of("13", "5", "/", "4", "+")));
    }

    @Test
    void testNegativeNumbersWithOperations() {
        assertEquals(-2, calculator.evaluateRpn(List.of("4", "-3", "2", "*", "+")));
    }

    @Test
    void testComplexExpressionWithSubtraction() {
        assertEquals(-15, calculator.evaluateRpn(List.of("2", "3", "+", "4", "5", "*", "-")));
    }

    @Nested
    @Disabled("Edge cases not yet implemented")
    class EdgeCaseTests {

        private RpnCalculator calculator;

        @BeforeEach
        void setUp() {
            calculator = new RpnCalculator();
        }

        @Test
        void testDivisionByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.evaluateRpn(List.of("4", "0", "/")));
        }

        @Test
        void testEmptyInput() {
            assertThrows(IllegalArgumentException.class, () -> calculator.evaluateRpn(List.of()));
        }

        @Test
        void testInvalidInput() {
            assertThrows(IllegalArgumentException.class, () -> calculator.evaluateRpn(List.of("2", "4", "invalid", "+")));
        }
    }
}