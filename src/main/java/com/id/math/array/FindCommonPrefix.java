package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find common prefix of string array.
 */
public class FindCommonPrefix {

    /**
     * Complexity is O(NM) where N- array size, M - minimum string size.
     *
     * @param arr array of strings to find prefix
     * @return max common prefix
     */
    public String find(String arr[]) {
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

    @Test
    public void test() {
        String arr[] = new String[]{};
        assertEquals("", find(arr));

        arr = new String[]{"", "", "", ""};
        assertEquals("", find(arr));

        arr = new String[]{"123", "1234", "12", "", "567", "12"};
        assertEquals("", find(arr));

        arr = new String[]{"123", "1234", "12", "12", "1"};
        assertEquals("1", find(arr));

        arr = new String[]{"abcdef", "abcde", "abc", "abcdefjh", "abcdef"};
        assertEquals("abc", find(arr));


    }
}
