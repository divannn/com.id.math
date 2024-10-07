package com.id.math.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class CompressString {

    public static String compress(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int consecutiveCount = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            consecutiveCount++;
            if (i + 1 == chars.length || c != chars[i + 1]) {
                sb.append(c);
                sb.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }

        String r = sb.toString();
        return r.length() < s.length() ? r : s;
    }

    @Test
    public void test() {
        assertEquals("a", compress("a"));
        assertEquals("a3", compress("aaa"));
        assertEquals("a3b1c4d2", compress("aaabccccdd"));
    }

}