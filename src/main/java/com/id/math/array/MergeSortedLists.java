package com.id.math.array;

import com.id.math.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedLists {

    // [1, 2, 4] + [3, 4] -> [1, 2, 3, 4, 4]
    public int[] merge(int[] a, int[] b) {
        if (a == null || b == null) {
            return null;
        }
        int aL = a.length;
        int bL = b.length;
        int[] result = new int[aL + bL];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aL && j < bL) {
            if (a[i] <= b[j]) {
                result[k] = a[i++];
            } else {
                result[k] = b[j++];
            }
            k++;
        }
        while (i < aL) {
            result[k] = a[i++];
            k++;
        }
        while (j < bL) {
            result[k] = b[j++];
            k++;
        }
        return result;
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {3, 4};
        int[] expected = {1, 2, 3, 4, 4};
        Arrays.sort(expected);
        int[] r = new MergeSortedLists().merge(arr1, arr2);
        ArrayUtils.printArray(r);
        Assert.assertArrayEquals(expected, r);
    }
}
