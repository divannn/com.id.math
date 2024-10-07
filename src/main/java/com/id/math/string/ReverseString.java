package com.id.math.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseString {

    private static String reverseString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            int lastInd = len - i - 1;
            chars[i] = chars[lastInd];
            chars[lastInd] = tmp;
        }
        return new String(chars);
    }

    private static String reverseString2(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("1", reverseString("1"));
        assertEquals("ba", reverseString("ab"));
        assertEquals("54321dcba", reverseString("abcd12345"));
    }

    @Test
    public void test2() {
        assertEquals("1", reverseString2("1"));
        assertEquals("ba", reverseString2("ab"));
        assertEquals("54321dcba", reverseString2("abcd12345"));
    }

}
