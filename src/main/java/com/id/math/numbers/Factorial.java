package com.id.math.numbers;

import java.math.BigInteger;

/**
 * @author idanilov
 *
 */
public class Factorial {

	private final static int NUM = 20;

	public static void main(String[] args) {
		factorial1();
		factorial2();
	}

	//BigInteger solution.
	private static void factorial1() {
		//BigInteger solution.
		System.out.println("good numbers for n = " + NUM);
		BigInteger n = BigInteger.ONE;
		for (int i = 1; i <= NUM; i++) {
			n = n.multiply(BigInteger.valueOf(i));
			System.out.println(i + "! = " + n);
		}
	}

	//int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
	private static void factorial2() {
		System.out.println("bad numbers for n = " + NUM);
		int fact = 1;
		for (int i = 1; i <= NUM; i++) {
			fact = fact * i;
			System.out.println(i + "! = " + fact);
		}
	}

}
