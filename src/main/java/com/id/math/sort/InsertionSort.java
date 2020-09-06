package com.id.math.sort;

import com.id.math.util.ArrayUtils;

/**
 * @author idanilov
 * @time in worse case : O(n*n)
 * @stable true
 */
public class InsertionSort extends AbstractSort {

    public int[] sort(int[] d) {
        data = ArrayUtils.copy(d);
        for (int i = 1; i < data.length; i++) {
            //remember key.
            int key = data[i];
            //shift data in order to free position for key.
            int j = i;
            while (j > 0 && data[j - 1] > key) {
                data[j] = data[j - 1];
                j--;
            }
            //insert key into free position.
            data[j] = key;
        }
        return data;
    }

    public static void main(String[] args) {
        System.err.println("-=INSERTION SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new InsertionSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }

}
