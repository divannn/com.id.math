package com.id.math.bits;

public class Swap {

    public static void main(String[] args) {
        swap1(2, 9);
        swap2(3, -1);
    }

    //1 сложением/вычитанием
    //Может возникнуть переполнение.
    public static void swap1(int a, int b) {
        System.err.println("swap1: a=" + a + " b=" + b);
        a = a - b; //diff
        b = b + a; //=a
        a = b - a; //=b
        System.err.println("swap1: a=" + a + " b=" + b);
    }

    //2 через XOR
    //Переполнение тут не грозит.
    public static void swap2(int a, int b) {
        System.err.println("swap2: a=" + a + " b=" + b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.err.println("swap2: a=" + a + " b=" + b);
    }

}
