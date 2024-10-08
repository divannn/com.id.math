package com.id.puzzles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Generate Nth item of "Look and Say" (aka "Count and Say") sequence:
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 * 1113213211
 * 31131211131221
 *
 * @company facebook
 * @company leetcode
 */
public class LookAndSaySequence {

    /**
     * Generate
     * @param n Nth number staring from 0
     * @return Nth number
     */
    String genLookAndSaySequence(int n) {
        if (n < 0) {
            return "";
        }
        String value = "1";
        System.err.println(value);
        for (int i = 1; i <= n; i++) {
            value = genNext(value);
            System.err.println(value);
        }
        return value;
    }

    String genNext(String prev) {
        char[] chars = prev.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                result.append(count).append(chars[i - 1]);
                count = 1;
            } else {
                count++;
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        String value = new LookAndSaySequence().genLookAndSaySequence(0);
        assertEquals("1", value);

        value = new LookAndSaySequence().genLookAndSaySequence(1);
        assertEquals("11", value);

        value = new LookAndSaySequence().genLookAndSaySequence(2);
        assertEquals("21", value);

        value = new LookAndSaySequence().genLookAndSaySequence(3);
        assertEquals("1211", value);
    }
}
