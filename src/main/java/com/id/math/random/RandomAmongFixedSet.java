package com.id.math.random;

import java.util.HashMap;
import java.util.Random;

/**
 * Дан массив пар интов: число и вес. Возвращает рандомное число из заданных, где веса - отношения вероятности выпадения.
 * Т.е. если задано [10, 1;20, 2;30, 4], то 30 должно выпадать в 4 раза чаще чем 10.
 */
public class RandomAmongFixedSet {

    //weight-> value
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int total = 0;

    public RandomAmongFixedSet(Pair[] set) {
        if (set == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        int i = 0;
        for (Pair p : set) {
            total += p.weight;
            for (; i < total; i++) {
                map.put(i, p.value);
            }
        }
    }

    public int get() {
        Random r = new Random();
        return map.get(r.nextInt(total));
    }

    public static void main(String[] args) {
        Pair[] set = {new Pair(10, 1), new Pair(20, 2), new Pair(30, 4)};
        RandomAmongFixedSet r = new RandomAmongFixedSet(set);
        System.err.println(">> " + r.get());
    }
}


class Pair {

    int value;
    int weight;

    Pair(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

