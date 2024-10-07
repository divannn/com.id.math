package com.id.math.string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatingChar {

    /**
     * Find first non-repeating char that is not found before in passed string
     *
     * @param s input
     * @return 1st non-repeating char that wasn't seen before
     */
    private static char find(String s) {
        if (s == null) {
            throw new IllegalArgumentException("invalid input");
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        for (char n : chars) {
            Integer num = m.get(n);
            if (num == null) {
                m.put(n, 1);
            } else {
                m.put(n, ++num);
            }
        }
        for (char n : chars) {
            Integer num = m.get(n);
            if (num == 1) {
                return n;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(0, find(""));
        assertEquals('a', find("a"));
        assertEquals('1', find("123"));
        assertEquals('3', find("1132124"));
    }

}
