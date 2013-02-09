package com.id.math.cursera_algo1;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {

    public static void main(String[] args) throws FileNotFoundException {
        int[] ints = readInts(InversionCount.class.getResourceAsStream("IntegerArray.txt"));
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

    private static int[] readInts(InputStream is) {
        final int N = 100000;
        int[] result = new int[N];
        Scanner s = new Scanner(is);
        int i = 0;
        while (s.hasNextInt() && i < N) {
            result[i++] = s.nextInt();
        }
        return result;
    }

}
