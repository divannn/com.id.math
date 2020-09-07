package com.id.math.array;

/**
 * Find a contiguous subarray with the largest sum, within a given one-dimensional array. Return that sum
 */
public class SubArraySum {

    /**
     * @param arr - source
     * @return laregest sum of contiguous subarray
     * @time O(n * n)
     */
    public static int subArraySum1(int[] arr) {
        int res = Integer.MIN_VALUE;
        for (int startInd = 0; startInd < arr.length; startInd++) {
            int sum = 0;
            for (int subArraySize = 1; subArraySize <= arr.length; subArraySize++) {
                if (startInd + subArraySize > arr.length) {
                    break;
                }
                sum += arr[startInd + subArraySize - 1];//last item in current subarray
                res = Math.max(res, sum);
                System.err.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int r = subArraySum1(new int[]{-2, 2, 3, -4, 1});
        System.err.println("r = " + r);
    }
}
