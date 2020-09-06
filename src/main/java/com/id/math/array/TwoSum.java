package com.id.math.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * You have an unsorted array, and you are given a value S. Find first pair of elements in the array that add up to value S.
 */
public class TwoSum {

    /**
     * Brute force
     * Time : O(n*n)
     * Space: O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * two-pass hash map
     * @time : O(n)
     * @space: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer ind = map.get(complement);
            if (ind != null && ind != i) {
                return new int[]{i, ind};
            }
        }
        return null;
    }

    /**
     * one-pass hash map
     * Time : O(n)
     * Space: O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer ind = map.get(complement);
            if (ind != null) {
                return new int[]{ind, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test1() {
        int[] arr = {0, 2, 7, 11, 15};
        assertArrayEquals(new int[]{0, 2}, twoSum1(arr, 7));
        assertArrayEquals(new int[]{0, 2}, twoSum2(arr, 7));
        assertArrayEquals(new int[]{0, 2}, twoSum3(arr, 7));
    }
}

