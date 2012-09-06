package com.id.math.sort;


import com.id.math.util.ArrayUtils;

/**
 * @author idanilov
 * @complexity in worse case : O(n*n)
 * @stable false
 */
public class SelectionSort extends AbstractSort {

    public int[] sort(int[] d) {
        data = ArrayUtils.copy(d);
        //don't need to process last element.
        for (int i = 0; i < data.length - 1; i++) {
            int minInd = ArrayUtils.minIndex(data, i, data.length);
            ArrayUtils.swap(data, i, minInd);
        }
        return data;
    }

    public static void main(String[] args) {
        System.err.println("-=INSERTION SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new SelectionSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }

}
