package com.id.math.util;

public class GCD {
    /**
     * Finds Greatest Common Divider.
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
