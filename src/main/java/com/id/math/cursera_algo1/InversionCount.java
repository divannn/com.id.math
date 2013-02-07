package com.id.math.cursera_algo1;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {

    public static void main(String[] args) throws FileNotFoundException {
        int[] ints = readInts(InversionCount.class.getResourceAsStream("ints.txt"));
        System.err.println(">> " + Arrays.toString(ints));
    }

    private static int[] readInts(InputStream is) throws FileNotFoundException {
        final int N = 10;
        int[] result = new int[N];
        Scanner s = new Scanner(is);
        int i = 0;
        while (s.hasNextInt() && i < N) {
            result[i++] = s.nextInt();
        }
        return result;
    }

}
