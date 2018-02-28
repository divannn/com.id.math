package com.id.math.stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesisSequence {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public boolean check(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == OPEN) {
                st.push(ch);
            } else if (ch == CLOSE) {
                if (st.empty()) {
                    return false;
                } else {
                    Character prev = st.peek();
                    if (prev == OPEN) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }

        }
        return st.empty();
    }

    // O(1) memory
    public boolean check2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        long num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
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
        assertTrue(check2("()"));
        assertTrue(check2("()()()"));
        assertTrue(check2("(())"));
        assertTrue(check2("(()()(()))()"));

        assertFalse(check2(""));
        assertFalse(check2("("));
        assertFalse(check2(")"));
        assertFalse(check2(")("));
        assertFalse(check2("(()()(()))("));
    }
}
