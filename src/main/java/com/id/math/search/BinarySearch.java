package com.id.math.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {1, 30, -5, 6, 8, 4, 64, 6, 8, 0, 2, 4, 3};
        int ind = binarySearch(data, 61);
        System.err.println(">>> ind:  " + ind);
    }

    public static int binarySearch(int[] array, int target) {
        if (array == null) {
            return -1;
        }
        int left = 0;
        int right = array.length;
        int middle = (left + right) / 2;

        while (true) {
            if (array[middle] == target)   {
                return middle;
            }

            if (left == middle || right == middle) {
                return -1;
            }

            if (array[middle] < target) {
                left = middle;
                middle = (left + right) / 2;
            }

            if (array[middle] > target) {
                right = middle;
                middle = (left + right) / 2;
            }
        }
    }
}
