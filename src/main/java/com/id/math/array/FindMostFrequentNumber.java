package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * В последовательности записаны целые числа, больше половины из которых равны одному и тому же числу X.
 * За один просмотр последовательности найти это число.
 *
 *  Если мы вычеркнем из последовательности два различных числа, то условие задачи останется верным.
 *  Поэтому мы можем вычёркивать пары различных чисел до тех пор, пока все элементы не станут равными одному и тому же числу.
 *  Это число и будет X.
 */
public class FindMostFrequentNumber {

    private int find(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("invalid input");
        }
        int curr = 0;
        int counter = 0;
        for (int item : arr) {
            if (counter == 0) {
                curr = item;
                counter++;
            } else if (curr == item) {
                counter++;
            } else {
                counter--;
            }
        }
        return curr;
    }

    @Test
    public void test() {
        int[] arr = {8, 8, 8, 8, 2, 3, 8, 8, 1, 3, 8, 3, 8, 8, 7, 8,};
        assertEquals(8, find(arr));

        int[] arr2 = {0, 2, 4, 7, 7, 7, 8, 9};
        assertEquals(7, find(arr2));

        //assertEquals(1, find(new int [] {1,2,1}));

        //assertEquals(1, find(new int [] {1,1,1}));
    }

}
