package com.id.math.stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesisSequence {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    /**
     * Allowed  parenthesis: (.
     * Example:
     * "(())()" - valid
     * "())" - invalid
     *
     * @param s input
     * @return true if string is valid parenthesis sequence
     */
    private boolean check(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char ch : chars) {
            if (ch == OPEN) {
                st.push(ch);
            } else if (ch == CLOSE) {
                if (st.empty()) {
                    return false;
                } else {
                    Character prev = st.pop();
                    if (prev != OPEN) {
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }

    /**
     * Extended of check(). Allowed parenthesis: (,[,{.
     * Example, "([)]" - invalid
     *
     * @param s input
     * @return true if string is valid parenthesis sequence
     */
    private static boolean check2(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            //Trick!!! Push right parentheses instead left to easy check
            if (c == '(')
                st.push(')');
            else if (c == '{')
                st.push('}');
            else if (c == '[')
                st.push(']');
            else if (st.isEmpty() || st.pop() != c)
                return false;
        }
        return st.isEmpty();
    }

    // O(1) memory
    private boolean check3(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 == 1) {
            return false;
        }
        long num = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == OPEN) {
                num++;
            } else if (ch == CLOSE) {
                num--;
                if (num < 0) {
                    return false;
                }
            }
        }
        return num == 0;
    }

    @Test
    public void test() {
        assertTrue(check("()"));
        assertTrue(check("()()()"));
        assertTrue(check("(())"));
        assertTrue(check("(()()(()))()"));

        assertFalse(check(""));
        assertFalse(check("("));
        assertFalse(check(")"));
        assertFalse(check(")("));
        assertFalse(check("(()()(()))("));
    }

    @Test
    public void test2() {
        assertTrue(check2("([]){{}}"));
        assertFalse(check2("(()()(()))["));
        assertFalse(check2("([)]"));
    }

    @Test
    public void test3() {
        assertTrue(check3("()"));
        assertTrue(check3("()()()"));
        assertTrue(check3("(())"));
        assertTrue(check3("(()()(()))()"));

        assertFalse(check3(""));
        assertFalse(check3("("));
        assertFalse(check3(")"));
        assertFalse(check3(")("));
        assertFalse(check3("(()()(()))("));
    }
}
