package com.id.math.sort;


import com.id.math.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author idanilov
 * @complexity in worse case : O(n*ln(n)).
 * @stable true
 */
public class MergeSort extends AbstractSort {

    private int[] helper;

    /**
     * Merge-sort the array.
     *
     * @param arr to be sorted
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        helper = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    // lo - left index inclusive
    // hi - left index inclusive
    private void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int middle = (lo + hi) / 2;
        sort(arr, 0, middle);
        sort(arr, middle + 1, hi);
        merge(arr, lo, middle, hi);
    }

    // lo - left index inclusive
    // mi - middle incex
    // hi - left index inclusive
    private void merge(int[] arr, int lo, int mi, int hi) {
        //make a copy initial array
        for (int i = lo; i <= hi; i++) {
            helper[i] = arr[i];
        }

        int i = lo;    //index for left sub-array
        int j = mi + 1;//index for right sub-array
        int k = lo;    //index to start filling result of the merge
        while (i <= mi && j <= hi) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i++];
            } else {
                arr[k] = helper[j++];
            }
            k++;
        }

        //fill the remaining part either left sub-array or right sub-array
        while (i <= mi) {
            arr[k] = helper[i++];
            k++;
        }
        while (j <= hi) {
            arr[k] = helper[j++];
            k++;
        }
    }

    public static void main(String[] args) {
        System.err.println("-=MERGE SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new MergeSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }


    @Test
    public void test() {
        int[] source = {1, 1, 0, 0, 2, 2, 3, 0};
        int [] copy = Arrays.copyOf(source, source.length);
        ArrayUtils.printArray(source);

        int[] r = new MergeSort().sort(source);
        ArrayUtils.printArray(r);

        Arrays.sort(copy);
        Assert.assertArrayEquals(copy, r);
    }

}
