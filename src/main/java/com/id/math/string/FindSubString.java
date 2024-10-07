package com.id.math.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSubString {


    @Test
    public void test1() {
        assertEquals(4, naive("12345", "abcd12345"));
        assertEquals(0, naive("abc", "abcd12345"));
        assertEquals(-1, naive("123456", "abcd12345"));
    }

    @Test
    public void test2() {
        assertEquals(4, rk("12345", "abcd12345"));
        assertEquals(0, rk("abc", "abcd12345"));
        assertEquals(-1, rk("123456", "abcd12345"));
    }
    /**
     * Naive - O(M*(N-M)).
     * Where M - size of needle, N - size of haystack.
     */
    private static int naive(String needle, String haystack) {
        if (needle == null || haystack == null) {
            return -1;
        }
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();

        outer:
        for (int i = 0; i <= haystackChars.length - needleChars.length; i++) {
            for (int j = 0; j < needleChars.length; j++) {
                if (needleChars[j] != haystackChars[i + j]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    private static int naive2(String n, String h) {
        char[] needle = n.toCharArray();
        char[] haystack = h.toCharArray();
        int needleIndex = 0;
        for (int i = 0; i < haystack.length; i++) {
            if (needle[needleIndex] == haystack[i]) {
                needleIndex++;
            } else {
                i -= needleIndex;
                needleIndex = 0;
                continue;
            }
            if (needleIndex == needle.length) {
                return i - n.length() + 1;
            }
        }
        return -1;
    }


    /**
     * Rabin-Karp - O(K*N).
     * Where M - size of needle, N - size of haystack.
     */
    private static int rk(String needle, String haystack) {
        char[] w = needle.toCharArray();
        char[] s = haystack.toCharArray();
        int wordhash = hash(w, 0, w.length, 0);
        int strhash = 0;
        for (int i = 0; i <= s.length - w.length; i++) {
            strhash = hash(s, i, w.length, strhash);
            if (strhash == wordhash) {
                //compare actual characters to be sure.
                boolean ok = true;
                for (int k = i, j = 0; k < w.length && ok; k++, j++)
                    if (s[k] != w[j]) {
                        ok = false;
                        break;
                    }
                if (ok)
                    return i;
            }
        }
        return -1;
    }

    // rolling hash function (sum of ASCII values)
    private static int hash(char[] s, int i, int len, int hval) {
        if (i == 0) {// first run, compute full hash
            hval = 0;
            for (int k = 0; k < len; k++)
                hval += s[k];
            return hval;
        }
        if (hval != 0 && i != 0)
            hval -= s[i - 1];
        if (i + len <= s.length)
            hval += s[i + len - 1];
        else // out of bounds
            return -1;
        return hval;
    }


}


