package com.id.math.numbers;

/**Least Common Multiple - Наименьшее общее кратное */
public class LCM {

    public static void main(String[] args) {
        System.err.println("> " + lcm(8,10));
    }

    public  static int lcm(int a, int b) {
        int gcd = GCD.gcd(a,b);
        return a*b/gcd;
    }
}
