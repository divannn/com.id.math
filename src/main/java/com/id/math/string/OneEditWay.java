package com.id.math.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 */

public class OneEditWay {

    public static boolean isOneEditAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {//!!! no need delete case - just reverse.
            return oneEditInsert(s2, s1);
        }
        return false;

    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    @Test
    public void testOnWayEdit() {
        assertFalse(isOneEditAway(null, "1212"));
        assertTrue(isOneEditAway("", ""));
        assertTrue(isOneEditAway("a", "a"));
        assertTrue(isOneEditAway("a", "1"));
        assertTrue(isOneEditAway("abcd", "1bcd"));
        assertTrue(isOneEditAway("abcd", "abc1"));
        assertTrue(isOneEditAway("abcde", "ab1de"));
        assertFalse(isOneEditAway("a", "12"));
    }

    @Test
    public void testOnWayInsert() {
        assertFalse(isOneEditAway(null, "1212"));
        assertTrue(isOneEditAway("a", ""));
        assertTrue(isOneEditAway("a", "ab"));
        assertTrue(isOneEditAway("abcd", "abcde"));
        assertTrue(isOneEditAway("abcd", "bcd"));
        assertTrue(isOneEditAway("abde", "abcde"));
    }

}