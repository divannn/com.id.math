package com.id.math.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Implement a method to check if to strings are anagrams (same set of chars forms another word).
 */
public class AnagramCheck {

    /**
     * Sort both strings then compare.
     * O(n*logn)
     */
    private static boolean isAnagram1(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    /**
     * Count letters and compare number of letters in both strings.
     * O(n)
     */
    private static boolean isAnagram2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(isAnagram1("", ""));
        assertTrue(isAnagram1("listen", "silent"));
        assertTrue(isAnagram1("triangle", "integral"));
        assertTrue(isAnagram1("1a3bc2a", "abca123"));
        assertFalse(isAnagram1("123", "ab"));
        assertFalse(isAnagram1("1234", "1235"));
    }

    @Test
    public void test2() {
        assertTrue(isAnagram2("", ""));
        assertTrue(isAnagram2("listen", "silent"));
        assertTrue(isAnagram2("triangle", "integral"));
        assertTrue(isAnagram2("1a3bc2a", "abca123"));
        assertFalse(isAnagram2("123", "ab"));
        assertFalse(isAnagram2("1234", "12345"));
    }

}