package com.id.math.cursera_algo1.w1;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Counts inversions for divide and conquer algorithm.
 *
 * @author idanilov
 *         <p/>
 *         Correct answers are:
 *         2407905288
 */

public class InversionCount {

    public static void main(String[] args) throws FileNotFoundException {
        int[] ints = readInts(InversionCount.class.getResourceAsStream("IntegerArray.txt"), 100000);
        /*for (int i = 0; i < ints.length; i++) {
           ints[i] = ints[i]/1000;
        }*/
        System.err.println(">> " + Arrays.toString(ints));
        System.err.println(">> inversion count:" + brut_force(ints));//returns long "2407905288"
    }

    private static long brut_force(int[] ints) {
        long result = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    result++;
                    //System.err.println(" " + ints[i] + ">" + ints[j]);
                }
            }
        }
        return result;
    }

    private static int[] readInts(InputStream is, int N) {
        int[] result = new int[N];
        Scanner s = new Scanner(is);
        int i = 0;
        while (s.hasNextInt() && i < N) {
            result[i++] = s.nextInt();
        }
        return result;
    }

}
