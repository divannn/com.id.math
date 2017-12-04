package com.id.math.random;

import java.util.Random;

public class Rand12ViaRand6 {

    /**
     * Given a function rand6() that returns random numbers from 1 to 6 with equal probability,
     * implement function rand12() that returns random numbers from 1 to 12 with equal probability.
     */
    public int rand12() {
        //rand6() * 2 will return even numbers 2, 4, 6, 8, 10 and 12 with equal probability
        //rand6() & 1 will return 0 or 1 based on rand6() is even or odd respectively.
        return (rand6() * 2) - (rand6() & 1);
    }


    public int rand12_2() {
        return rand6() + (rand6() % 2) * 6;
//        //rand6() is even
//        if (rand6() % 2 == 0) {
//            return 6 + rand6();
//        } else {//rand6() is odd
//            return rand6();
//        }
    }

    /**
     * @return random numbers from 1 to 6
     */
    private int rand6() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }

}
