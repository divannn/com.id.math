package com.id.math.cursera_algo1;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Counts comparisons for quick sort.
 *
 * @author idanilov
 *         <p/>
 *         Correct answers are:
 *         162085 - first
 *         164123 - last
 *         138382 - median of fist-middle-last
 */
public class QS {

    public static void main(String[] args) throws FileNotFoundException {
        //int[] ints = {2, 8, 9, 3, 7, 5, 10, 1, 6, 4};
        QSort qs = new QSort();

        int[] ints = readInts(QS.class.getResourceAsStream("QuickSort.txt"));
        //System.err.println(">> " + Arrays.toString(ints));
        qs.sort(ints, QSort.PIVOT_STARTEGY.FIRST);
        System.err.println("Comparison count = " + qs.count);
        ints = readInts(QS.class.getResourceAsStream("QuickSort.txt"));
        qs.sort(ints, QSort.PIVOT_STARTEGY.LAST);
        System.err.println("Comparison count = " + qs.count);
        ints = readInts(QS.class.getResourceAsStream("QuickSort.txt"));
        qs.sort(ints, QSort.PIVOT_STARTEGY.MEDIAN);
        System.err.println("Comparison count = " + qs.count);
    }

    private static int[] readInts(InputStream is) {
        final int N = 10000;
        int[] result = new int[N];
        Scanner s = new Scanner(is);
        int i = 0;
        while (s.hasNextInt() && i < N) {
            result[i++] = s.nextInt();
        }
        return result;
    }

}
