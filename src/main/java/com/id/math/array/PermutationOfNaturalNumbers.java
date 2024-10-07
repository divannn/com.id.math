package com.id.math.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given and unsorted array of positive numbers (can repeat) check if it's a permutation of array [1...N]
 * <p>
 * Example:
 * <p>
 * Input: {3,1,2,5,4}
 * Output: true
 *
 * @company facebook (I was asked)
 */
public class PermutationOfNaturalNumbers {

    /**
     * Via hash.
     *
     * @time : O(n)
     * @space: O(n)
     */
    private boolean viaHash(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (!set.add(num)) { //duplicate
                return false;
            }
            max = Math.max(max, num);
        }

        if (set.size() != nums.length) {//length should be the same
            return false;
        }
        return max == nums.length;//check max elem
    }

    /**
     * Via counting.
     *
     * @time : O(n)
     * @space: O(n)
     */
    private boolean viaCounting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int counter = 0;
        int[] count = new int[nums.length + 1];//as nums are positive.
        for (int num : nums) {
            if (num >= count.length) {//exceeds max element
                return false;
            }
            if (count[num] == 0) {
                count[num] = 1;
                counter++;
            } else { //duplicate found
                return false;
            }
        }
        return counter == nums.length;
    }

    /**
     * Via sorting.
     *
     * @time : O(n*logn)
     * @space: O(1)
     */
    private boolean viaSorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int counter = 0;
        for (int num : nums) {
            if (num != ++counter) {
                return false;
            }
        }
        return true;
    }

    /**
     * Via math. Idea is to check:
     * <p>
     * 1) sum of all elements of permutation = N*(N+1)/2
     * <p>
     * 2)  multiplication = N!
     * It doesn't work!!! See test example proving that this method doesn't work!
     *
     * @time : O(n)
     * @space: O(1)
     */
    private boolean viaMath(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        int mul = 1;
        for (int num : nums) {
            sum += num;
            mul *= num;
        }

        int expectedMul = 1;
        for (int i = 1; i <= nums.length; i++) {
            expectedMul *= i;//N!
        }
        int expectedSum = nums.length * (nums.length + 1) / 2;//N*(N+1)/2
        if (sum != expectedSum) {
            return false;
        }
        return mul == expectedMul;
    }

    @Test
    public void testViaHash() {
        int[] arr = {1, 2, 2, 4, 3};
        assertFalse(viaHash(arr));
        arr = new int[]{2, 2, 3};
        assertFalse(viaHash(arr));
        arr = new int[]{1, 2, 6, 4, 3, 5};
        assertTrue(viaHash(arr));
        arr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 9};
        assertFalse(viaHash(arr));
    }

    @Test
    public void testViaCounting() {
        int[] arr = {1, 2, 2, 4, 3};
        assertFalse(viaCounting(arr));
        arr = new int[]{2, 2, 3};
        assertFalse(viaCounting(arr));
        arr = new int[]{1, 2, 6, 4, 3, 5};
        assertTrue(viaCounting(arr));
        arr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 9};
        assertFalse(viaCounting(arr));
    }

    @Test
    public void testViaSorting() {
        int[] arr = {1, 2, 2, 4, 3};
        assertFalse(viaSorting(arr));
        arr = new int[]{2, 2, 3};
        assertFalse(viaSorting(arr));
        arr = new int[]{1, 2, 6, 4, 3, 5};
        assertTrue(viaSorting(arr));
        arr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 9};
        assertFalse(viaSorting(arr));
    }

    @Test
    public void testViaMath() {
        int[] arr = {1, 2, 3};
        assertTrue(viaMath(arr));

        //!!DOESN'T WORK sum (45) and mul (362880) are equals to expected
        arr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 9};
        assertFalse(viaMath(arr));
    }
}

