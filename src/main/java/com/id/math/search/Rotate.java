package com.id.math.search;

import com.id.math.util.ArrayUtils;

public class Rotate {

    public static void main(String[] args) {
        int[] data = {-2, 1, 2, 4, 5};
        ArrayUtils.printArray(data);
        rotateLeft(data, 2, );
        ArrayUtils.printArray(data);
    }

    public static void rotateLeft(int[] array, int d) {
        int n = array.length;
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) {
            /* move i-th values of blocks */
            temp = array[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    /*Function to get gcd of a and b*/
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
