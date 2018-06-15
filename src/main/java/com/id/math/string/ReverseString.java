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
            int lastInd = len - i - 1;
            str[i] = str[lastInd];
            str[lastInd] = tmp;
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
