package com.id.math.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {-2,1,2,4,5};
        int ind = binarySearch(data, 2);
        System.err.println(">>> ind:  " + ind);
    }

    public static int binarySearch(int[] array, int target) {
        if (array == null) {
            return -1;
        }
        int left = 0;
        int right = array.length;

        while (true) {
            int middle = (left + right) / 2;
            if (array[middle] == target)   {
                return middle;
            }

            if (left == middle || right == middle) {
                return -1;
            }

            if (array[middle] < target) {
                left = middle;
            } else if (array[middle] > target) {
                right = middle;
            }
        }
    }
}
