package com.id.math.bits;


public class BitTest {

    public static void main(String[] args) {
        int i = 1;
        System.err.println("+1: " + Integer.toBinaryString(i));
        System.err.println(" unsigned repr:" + Integer.toUnsignedString(i));
        System.err.println("  # bits: " + Integer.bitCount(i));

        System.err.println("-1: " + Integer.toBinaryString(-i));
        System.err.println(" unsigned repr:" + Integer.toUnsignedString(-i));
        System.err.println("  # bits: " + Integer.bitCount(-i));
    }
}
