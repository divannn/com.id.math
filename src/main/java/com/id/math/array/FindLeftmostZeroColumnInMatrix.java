package com.id.math.array;

import org.junit.Assert;
import org.junit.Test;

import static com.id.math.array.BinarySearch.binarySearch;

/**
 * Given a rectangular matrix M x N with rows formed of ones and zeroes which sorted in reverse order - find column index of leftmost zero.
 * Example:
 * <p/>
 * Input:
 * <p/>
 * m = [
 * [1,1,1,0,0],
 * [1,1,1,1,0],
 * [1,1,0,0,0],
 * [1,1,1,0,0],
 * [1,0,0,0,0],
 * ]
 * <p/>
 * Output:
 * 1
 *
 * @company facebook (I was asked)
 */
public class FindLeftmostZeroColumnInMatrix {

    /**
     * Naive - find first position of 0 in each row and find minimal among them.
     *
     * @param m - matrix
     * @return leftmost column index of value 0
     * @time O(MxN)
     */
    public int naive(int[][] m) {
        int res = Integer.MAX_VALUE;
        for (int[] row : m) {
            int cur = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {//find first 0 in row
                    cur = j;
                    break;
                }
            }
            if (cur < res && cur != -1) {
                res = cur;
            }
        }
        return res;
    }

    public int find(int[][] m) {
        int res = Integer.MAX_VALUE;
        for (int[] row : m) {
            int cur = binarySearch(row, 0);
            if (cur < res && cur != -1) {
                res = cur;
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int[][] m = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0},
        };
        Assert.assertEquals(3, naive(m));

        int[][] m2 = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        };
        Assert.assertEquals(0, naive(m2));
    }

    @Test
    public void test2() {
        int[][] m = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0},
        };
        Assert.assertEquals(3, find(m));

        int[][] m2 = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        };
        Assert.assertEquals(0, find(m2));
    }

}
