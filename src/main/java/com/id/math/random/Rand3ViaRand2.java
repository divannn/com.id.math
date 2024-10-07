package com.id.math.random;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Rand3ViaRand2 {

    /**
     * Given rand2() implement rand3().
     */
    public int rand3() {
        // returns 0, 1, 2 or 3 with 25% probability.
        int r = 2 * rand2() + rand2();
        if (r < 3) {//eliminate undesired 3.
            return r;
        }
        return rand3();
    }

    //another way
    //(0,0) - 25%
    //(1,1) - 25%
    //(1,0) - 25%
    //(0,1) - 25% - eliminate one.
    //sum  (0,0)+(1,1)+(1,0) will give 0,1,2 with 33%.
    int rand3_2() {
        int x, y;
        do {
            x = rand2();
            y = rand2();
        } while (x == 0 && y == 1);
        return x + y;
    }

    /**
     * generates a random number between O and 1 (inclusive)
     */
    private int rand2() {
        Random r = new Random();
        return r.nextInt(2);
    }

    @Test
    public void test() {
        System.err.println("");
        for (int i = 0; i < 1000; i++) {
            int v = rand3();
            assertTrue(v >= 0 && v < 3);
        }
    }

}
