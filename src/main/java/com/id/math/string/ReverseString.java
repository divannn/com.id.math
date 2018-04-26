package com.id.math.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseString {

    private static String reverseString(String s) {
        if (s == null) {
            return "";
        }
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = tmp;
        }
        return new String(str);
    }

    @Test
    public void test() {
        assertEquals("1", reverseString("1"));
        assertEquals("ba", reverseString("ab"));
        assertEquals("54321dcba", reverseString("abcd12345"));
    }

}
