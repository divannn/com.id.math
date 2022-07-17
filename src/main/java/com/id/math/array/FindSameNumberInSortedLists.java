package com.id.math.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * You have three sorted arrays.
 * You need to find same element in all arrays (first found) or -1 if there is no same element.
 *
 * @company tin
 */
public class FindSameNumberInSortedLists {

    public int find(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && a[i] == c[k]) {
                return a[i];
            }
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5};
        int[] arr3 = {4};
        int r = new FindSameNumberInSortedLists().find(arr1, arr2, arr3);
        System.err.println(">>>" + r);
        Assert.assertEquals(4, r);
    }

    @Test
    public void test2() {
        int[] arr1 = {1, 2, 3, 4, 6, 7};
        int[] arr2 = {0, 2, 3, 4, 5, 6};
        int[] arr3 = {6, 8, 9, 10, 13, 15};
        int r = new FindSameNumberInSortedLists().find(arr1, arr2, arr3);
        System.err.println(">>>" + r);
        Assert.assertEquals(6, r);
    }

    @Test
    public void test3() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 1, 2, 3, 4, 5};
        int[] arr3 = {5, 9};
        int r = new FindSameNumberInSortedLists().find(arr1, arr2, arr3);
        System.err.println(">>>" + r);
        Assert.assertEquals(-1, r);
    }
}
