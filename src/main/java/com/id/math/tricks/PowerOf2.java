package com.id.math.tricks;


public class PowerOf2 {
    public static void main(String[] args) {
        System.err.println("test 8: " + isPowerOf(8));
        System.err.println("test 67: " + isPowerOf(67));
    }

    public static boolean isPowerOf(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid arg");
        }
        return (value & value - 1) == 0;
    }

}
