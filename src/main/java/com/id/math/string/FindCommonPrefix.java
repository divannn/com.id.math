package com.id.math.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find longest common prefix of string array.
 */
//leetcode
//https://leetcode.com/problems/longest-common-prefix
public class FindCommonPrefix {

    /**
     * Complexity is O(NM) where N - array size, M - minimum string length.
     *
     * @param arr array of strings to find prefix
     * @return max common prefix
     */
    private String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        String result = "";
        int min_len = arr[0].length();
        for (String s : arr) {
            if (s.length() < min_len) {
                min_len = s.length();
            }
        }

        for (int i = 0; i < min_len; i++) {
            char nextCandidate = arr[0].charAt(i);
            for (String s : arr) {
                if (s.charAt(i) != nextCandidate) {
                    return result;
                }
            }
            result += nextCandidate;
        }

        return result;
    }

    //not mine
    //O(S), where S is the sum of all characters in all strings.
    private String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        return prefix;
    }

    @Test
    public void test() {
        String arr[] = new String[]{};
        assertEquals("", longestCommonPrefix(arr));

        arr = new String[]{"", "", "", ""};
        assertEquals("", longestCommonPrefix(arr));

        arr = new String[]{"123", "1234", "12", "", "567", "12"};
        assertEquals("", longestCommonPrefix(arr));

        arr = new String[]{"123", "1234", "12", "12", "1"};
        assertEquals("1", longestCommonPrefix(arr));

        arr = new String[]{"abcdef", "abcde", "abc", "abcdefjh", "abcdef"};
        assertEquals("abc", longestCommonPrefix(arr));
    }

    @Test
    public void test2() {
        String arr[] = new String[]{};
        assertEquals("", longestCommonPrefix2(arr));

        arr = new String[]{"", "", "", ""};
        assertEquals("", longestCommonPrefix2(arr));

        arr = new String[]{"123", "1234", "12", "", "567", "12"};
        assertEquals("", longestCommonPrefix2(arr));

        arr = new String[]{"123", "1234", "12", "12", "1"};
        assertEquals("1", longestCommonPrefix2(arr));

        arr = new String[]{"abcdef", "abcde", "abc", "abcdefjh", "abcdef"};
        assertEquals("abc", longestCommonPrefix2(arr));
    }
}
