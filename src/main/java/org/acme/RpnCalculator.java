package org.acme;

import java.util.List;

/**
 * Reverse Polish Notation (RPN)
 * What is RPN?
 * RPN is a mathematical notation in which every operator follows all its operands. It is also known as postfix notation.
 * In RPN, there is no need for parentheses to define the order of operations, which makes it simpler to implement on computers and calculators.
 * <p>
 * Task
 * Code Implementation: Implement the evaluateRpn(tokens) function, where tokens argument is an array with strings.
 * Constraints:
 * Each operand can be an integer or a string.
 * Division should be integer division where the result is truncated towards zero.
 * <p>
 * Examples:
 * ["2", "4", "*", "8", "+"] => 2 * 4 + 8 = 16
 * ["2", "4", "8", "+", "*"] => 2 * (4 + 8) = 24
 * ["8", "4", "/", "3", "*", "1", "+"] => 8 / 4 * 3 + 1 = 7
 * ["13", "5", "/", "4", "+"] => 13 / 5 + 4 = 6
 */
public class RpnCalculator {

    public Integer evaluateRpn(List<String> tokens) {
        return 0;
    }

}
