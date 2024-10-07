package com.id.math.array;

import com.id.math.util.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You have a set of players and their array of player ratings. Array size is even.
 * You need to find minimal bias.
 *
 * @company hackerrank
 */
public class MiminizeBias {

    public static int find(int[] scores) {
        Arrays.sort(scores);
        ArrayUtils.printArray(scores);
        int sum = 0;
        for (int i = 0; i < scores.length; i = i + 2) {
            sum += scores[i] - scores[i + 1];
        }
        return sum;
    }

    @Test
    public void test1() {
        int[] scores = {1, 8, 6, 6};
        int r = find(scores);
        System.err.println(r);
        assertEquals(-7, r);
    }

    @Test
    public void test2() {
        int[] scores = {1, 1, 2, 2};
        int r = find(scores);
        System.err.println(r);
        assertEquals(0, r);
    }
}

