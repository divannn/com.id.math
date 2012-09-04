package com.id.math.sort;


/**
 * @author idanilov
 * @complexity in worse case : O(n*n)
 * @stable true
 */
public class BubbleSort extends AbstractSort {

    public int[] sort(int[] d) {
        data = ArrayUtils.copy(d);
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    ArrayUtils.swap(data, j, j - 1);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        System.err.println("-=BUBBLE SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new BubbleSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }
}
