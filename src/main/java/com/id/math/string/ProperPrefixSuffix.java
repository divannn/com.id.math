package com.id.math.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Proper prefix of string S is beginning substring that shorter than S.
 * Proper suffix of string S is ending substring that shorter than S.
 * Find the longest proper prefix that also is proper suffix of given string S.
 *
 * Example1 : "codility" -> 0 as "" is common prefix and suffix
 * Example2 : "abbabba" -> 4 as "abba" is common prefix and suffix
 * @company zalando
 */
public class ProperPrefixSuffix {
    /**
     * @time O(n*n)
     * @space O(1)
     */
    int solution(String S) {
        char[] chars = S.toCharArray();
        int result = 0;
        //start from samples prefix and suffix of length 1 (think - maybe start from longest??)
        for (int i = 0; i < chars.length; i++) {
            if (equalSubstrings(chars, i, S.length() - i - 1)) {
                int properSubstringLength = i + 1;
                if (properSubstringLength < chars.length) {
                    result = properSubstringLength;
                }
            }
        }
        return result;
    }

    private boolean equalSubstrings(char[] arr, int prefixEnd, int suffixStart) {
        for (int i = 0; i <= prefixEnd; i++) {
            if (arr[i] != arr[suffixStart + i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        int r = new ProperPrefixSuffix().solution("abbabba");
        System.err.println(r);
        assertEquals(4, r);
    }

    @Test
    public void test2() {
        int r = new ProperPrefixSuffix().solution("codility");
        System.err.println(r);
        assertEquals(0, r);
    }

    @Test
    public void test3() {
        int r = new ProperPrefixSuffix().solution("123123");
        System.err.println(r);
        assertEquals(3, r);
    }

    @Test
    public void test4() {
        int r = new ProperPrefixSuffix().solution("44444");
        System.err.println(r);
        assertEquals(4, r);
    }

    @Test
    public void test5() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append("a");
        }
        int r = new ProperPrefixSuffix().solution(sb.toString());
        System.err.println(r);
        assertEquals(99_999, r);
    }
}
