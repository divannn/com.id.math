package com.id.math.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * You have a set of players and their array of player ratings. Array size is even.
 * You need to find minimal bias.
 * @company hackerrank
 */
public class MiminizeBias {
    public static void main(String[] args) {
        List<Integer> r = Arrays.asList(1, 3, 6, 6);
        r.sort((a, b) -> a - b);
        System.err.println(r);
        int sum = 0;
        for (int i = 0; i < r.size(); i = i + 2) {
            sum = sum + (r.get(i) - r.get(i + 1));
        }
        System.err.println(sum);
    }
}

