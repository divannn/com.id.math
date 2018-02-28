package com.id.math.stack;


import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SequenceWithBackspaceChecker {

    //Check if two sequences are the same
    //[‘a’, ‘b’, ‘c’, ‘\b’]   -> ab
    //                                 => true
    //[‘a’, ‘p’, ‘\b’, ‘b’]   -> ab
    public static boolean isTheSame(char[] seq1, char[] seq2) {
        if (seq1 == null || seq2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<Character> col1 = filter(seq1);
        List<Character> col2 = filter(seq2);
        if (col1.size() != col2.size()) {
            return false;
        }
        for (int i = 0; i < col1.size(); i++) {
            if (col1.get(i) != col2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Character> filter(char[] seq) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == '\b') {
                if (!st.empty()) {
                    st.pop();
                }
            } else {
                st.push(seq[i]);
            }
        }
        return st;
    }


    @Test
    public void test() {
        char[] s1 = {'a', 'b', 'c', '\b'};
        char[] s2 = {'a', 'p', '\b', 'b'};
        assertTrue(isTheSame(s1, s2));

        s1 = new char[]{'a', 'b'};
        s2 = new char[]{'a', 'p'};
        assertFalse(isTheSame(s1, s2));

        s1 = new char[]{'\b'};
        s2 = new char[]{'\b', '\b'};
        assertTrue(isTheSame(s1, s2));
    }
}

