package com.id.math.random;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Rand7ViaRand5 {

    /**
     * Given rand5() implement rand7().
     */
    public int rand7() {
        while (true) {
            int r1 = 2 * rand5();//evens in [0-8]
            int r2 = rand5();//[0-4]
            if (r2 != 4) {
                int rand1 = r2 % 2;//0 or 1
                int num = r1 + rand1;//will be in [0-9]
                if (num < 7) {
                    return num;
                }
            }
        }
    }

    /**
     * @return random numbers from 0 to 4
     */
    private int rand5() {
        Random r = new Random();
        return r.nextInt(5);
    }

    @Test
    public void test() {
        System.err.println("");
        for (int i = 0; i < 1000; i++) {
            int v = rand7();
            assertTrue(v >= 0 && v < 7);
        }
    }

}
