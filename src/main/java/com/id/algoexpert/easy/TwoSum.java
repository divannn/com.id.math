package com.id.algoexpert.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given array of distinct integers and targetSum integer.
 * If any two values sum up to targetSum - return them as array in any order.
 * Return array of 2 values [v1, v2] so that v1 + v2 = targetSum.
 * <p>
 * Note: you cannot add same value to itself!
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        int[] r = twoNumberSum1(arr, 10);
        System.err.println(Arrays.toString(r));

        arr = new int[] {3, 5};
        r = twoNumberSum1(arr, 8);
        System.err.println(Arrays.toString(r));

        arr = new int[] {3, 4};
        r = twoNumberSum1(arr, 8);
        System.err.println(Arrays.toString(r));

        arr = new int[] {0, 1, -2};
        r = twoNumberSum1(arr, -1);
        System.err.println(Arrays.toString(r));
    }

    /**
     * O(n) time, O(n) space
     *
     * @param array     unique integer values
     * @param targetSum target sum
     * @return array of 2 values [v1, v2] so that v1 + v2 = targetSum
     */
    public static int[] twoNumberSum1(int[] array, int targetSum) {
        if (array == null) {
            return new int[0];
        }
        Set<Integer> cache = new HashSet<>();//cache the addition for each item
        for (int val : array) {
            Integer addition = targetSum - val;
            if (cache.contains(addition)) {
                return new int[] {val, addition};
            }
            else {
                cache.add(val);
            }
        }
        return new int[0];
    }

    /**
     * O(nlog) time, O(1) space
     */
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        if (array == null) {
            return new int[0];
        }
        Arrays.sort(array);//O(nlog) time - sort
        int l = 0, r = array.length - 1;
        while (l < r) {//O(n) time - meat
            int sum = array[l] + array[r];
            if (sum < targetSum) {
                l++;
            }
            else if (sum > targetSum) {
                r--;
            }
            else {
                return new int[] {array[l], array[r]};
            }
        }
        return new int[0];
    }

}

