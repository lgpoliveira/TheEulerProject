package source;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * Multiples of 3 and 5 If we list all the natural numbers below 10 that are
	 * multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is
	 * 23. Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	private static long problem1() {
		long answer = 0;
		for (int i = 3; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				answer += i;
		}
		return answer;
	}

	/**
	 * Even Fibonacci numbers Each new term in the Fibonacci sequence is
	 * generated by adding the previous two terms. By starting with 1 and 2, the
	 * first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... By
	 * considering the terms in the Fibonacci sequence whose values do not
	 * exceed four million, find the sum of the even-valued terms.
	 **/
	private static long problem2() {
		long answer = 0, lastValue = 0, actualValue = 1;
		while (actualValue <= 4000000) {
			long temp = actualValue;
			actualValue = actualValue + lastValue;
			lastValue = temp;
			if (actualValue % 2 == 0)
				answer += actualValue;
		}

		return answer;
	}

	/**
	 * Largest prime factor 
	 * The prime factors of 13195 are 5, 7, 13 and 29. 
	 * What is the largest prime factor of the number 600851475143 ?
	 **/
	private static long problem3() {

		long rootNumber = 600851475143L;
		long newnumm = rootNumber;
		long answer = 0;
		int counter = 2;
		while (counter * counter <= newnumm) {
			if (newnumm % counter == 0) {
				newnumm = newnumm / counter;
				answer = counter;
			} else {
				counter++;
			}
		}
		if (newnumm > answer) { // the remainder is a prime number
			answer = newnumm;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println("The Euler Project");
		System.out.println("The answer for Problem 1 - Multiples of 3 and 5 is: " + problem1());
		System.out.println("The answer for Problem 2 - Fibonacci even Numbers is: " + problem2());
		System.out.println("The answer for Problem 3 - Largest prime factor is: " + problem3());
	}

}
