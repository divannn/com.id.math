package com.id.math.array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {-2, 1, 2, 4, 5};
        int ind = binarySearch(data, 2);
        System.err.println(">>> ind :  " + ind);
        int ind2 = binarySearch2(data, 12, 0, data.length - 1);
        System.err.println(">>> ind2:  " + ind2);
    }


    public static int binarySearch(int[] array, int target) {
        if (array == null) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //recursive way.
    public static int binarySearch2(int[] array, int target, int left, int right) {
        if (array == null) {
            return -1;
        }
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (array[middle] < target) {
            left = middle + 1;
        } else if (array[middle] > target) {
            right = middle - 1;
        } else {
            return middle;
        }
        return binarySearch2(array, target, left, right);
    }

}
