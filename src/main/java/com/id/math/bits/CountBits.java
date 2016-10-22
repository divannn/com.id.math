package com.id.math.bits;


public class CountBits {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int v = 0;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits1(v));
        v = 8;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits1(v));
        v = 0xFF;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits1(v));
        v = 24279;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits1(v));
    }

    private static void test2() {
        System.err.println("--------------------");
        int v = 0;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits2(v));
        v = 8;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits2(v));
        v = 0xFF;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits2(v));
        v = 24279;
        System.err.println(Integer.toBinaryString(v) + " -> " + countToggledBits2(v));
    }

    /** Naive - shift bits top right on by one.
     * O(log2 N) = O(number of digits) */
    public static short countToggledBits1(int value) {
        short result = 0;
        while (value > 0) {
            result += value & 1;
            value >>= 1;
        }
        return result;
    }

    /** Better way. Use "check power of 2 trick".
     * O(number of toggled bits). O(log2 N) in worst case - when all bits are toggled. */
    public static short countToggledBits2(int value) {
        short result = 0;
        while (value > 0) {
            value &= value & (value - 1);
            result++;
        }
        return result;
    }


}
