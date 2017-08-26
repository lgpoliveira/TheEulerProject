package source;

import java.util.ArrayList;
import java.util.List;

import problems.*;

//TODO: Refactor the main class and put each problem method in a separate class
public class Main {

	

	/**
	 * Sum square difference The sum of the squares of the first ten natural
	 * numbers is, 12 + 22 + ... + 102 = 385 The square of the sum of the first
	 * ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025 Hence the
	 * difference between the sum of the squares of the first ten natural
	 * numbers and the square of the sum is 3025 − 385 = 2640. Find the
	 * difference between the sum of the squares of the first one hundred
	 * natural numbers and the square of the sum.
	 */
	private static long problem6() {
		long answer = 0, sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			answer += (i * i);
		}
		answer = (sum * sum) - answer;
		return answer;
	}

	/**
	 * 10001st prime By listing the first six prime numbers: 2, 3, 5, 7, 11, and
	 * 13, we can see that the 6th prime is 13. What is the 10 001st prime
	 * number?
	 */
	private static long problem7() {
		List<Long> primes = new ArrayList<Long>();
		long count = 1;
		boolean isPrime = true;
		primes.add(2L);
		while (primes.size() < 10001) {
			count += 2;
			int j = 0;
			isPrime = true;
			while ((primes.get(j) * primes.get(j)) <= count) {
				if (count % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
				j++;
			}
			if (isPrime) {
				primes.add(count);
			}

		}
		return primes.get(primes.size() - 1);
	}

	/**
	 * Largest product in a series The four adjacent digits in the 1000-digit
	 * number that have the greatest product are 9 × 9 × 8 × 9 = 5832. Find the
	 * thirteen adjacent digits in the 1000-digit number that have the greatest
	 * product. What is the value of this product?
	 */
	private static long problem8() {
		StringBuffer baseNumber = new StringBuffer();
		baseNumber.append("73167176531330624919225119674426574742355349194934")
				.append("96983520312774506326239578318016984801869478851843")
				.append("8586156078911294949545950173795833195285328805511")
				.append("12540698747158523863050715693290963295227443043557")
				.append("66896648950445244523161731856403098711121722383113")
				.append("6222989342338038135336276614282806444486645238749")
				.append("3035890729629049156044077239071381051585930796866")
				.append("701724271218839987979879227492190169972888093776")
				.append("65727333001053367881220235421809751254540594752243")
				.append("52584907711670556013604839586446706324415722155397")
				.append("5369781797784617406495514929862569321978468622482")
				.append("83972241375657056057490261407972968652414535100474")
				.append("8216637048440319989008895243450658541227588666881")
				.append("1642717147992444292823863465674813919123162824586")
				.append("17866458359124566529476545682848912883142607690042")
				.append("2421902267105562632111110937054421750694165896048")
				.append("07198403850962455444362981230987879927244284909188")
				.append("84580156166097919133875499200524063689912560717606")
				.append("05886116467109405077541002256983155200055935729725")
				.append("7163626956188267042825248360823257530420752963450");
		char[] dst = new char[13];
		int actualInit = 0;
		int actualEnd = 13;
		long answer = 0;
		long calc = 0;
		while (actualEnd <= baseNumber.length() - 1) {
			calc = 1;
			dst = new char[13];
			baseNumber.getChars(actualInit, actualEnd, dst, 0);
			if (!containsZero(dst)) {
				for (int i = 0; i < dst.length; i++) {
					calc = calc * Long.valueOf(String.valueOf(dst[i]));
				}
				if (calc > answer)
					answer = calc;
				actualInit++;
				actualEnd++;
			} else {
				actualInit = actualInit + String.valueOf(dst).lastIndexOf("0") + 1;
				actualEnd = actualInit + 13;
			}
		}
		return answer;
	}

	private static boolean containsZero(char[] dst) {
		for (int i = 0; i < dst.length; i++) {
			if (Long.valueOf(String.valueOf(dst[i])) == 0)
				return true;
		}
		return false;
	}

	/**
	 * Special Pythagorean triplet A Pythagorean triplet is a set of three
	 * natural numbers, a < b < c, for which, a^2 + b^2 = c^2 For example, 3^2 +
	 * 4^2 = 9 + 16 = 25 = 5^2. There exists exactly one Pythagorean triplet for
	 * which a + b + c = 1000. Find the product abc.
	 */
	private static long problem9() {
		int a = 0, b = 0, c = 0, sum;
		boolean found = false;
		sum = 1000;
		long answer;
		for (a = 1; a < sum / 3; a++) {
			for (b = a; b < sum / 2; b++) {
				c = sum - a - b;
				if (a * a + b * b == c * c) {
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		answer = a * b * c;
		return answer;
	}

	/**
	 * Summation of primes The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 */
	private static long problem10() {
		List<Long> primes = new ArrayList<Long>();
		long count = 1;
		boolean isPrime = true;
		primes.add(2L);
		while (primes.get(primes.size() - 1) < 2000000) {
			count += 2;
			if (count >= 2000000) {
				break;
			}
			int j = 0;
			isPrime = true;
			while ((primes.get(j) * primes.get(j)) <= count) {
				if (count % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
				j++;
			}
			if (isPrime) {
				primes.add(count);
			}

		}
		return primes.stream().mapToLong(Long::longValue).sum();

	}

	/**
	 * Largest product in a grid In the 20×20 grid below, four numbers along a
	 * diagonal line have been marked in red. The product of these numbers is 26
	 * × 63 × 78 × 14 = 1788696. What is the greatest product of four adjacent
	 * numbers in the same direction (up, down, left, right, or diagonally) in
	 * the 20×20 grid?
	 */
	private static long problem11() {
		int[][] matrix = new int[][] { { 8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8 },
				{ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0 },
				{ 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65 },
				{ 52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91 },
				{ 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80 },
				{ 24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50 },
				{ 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70 },
				{ 67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21 },
				{ 24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72 },
				{ 21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95 },
				{ 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92 },
				{ 16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57 },
				{ 86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58 },
				{ 19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40 },
				{ 4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66 },
				{ 88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69 },
				{ 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36 },
				{ 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16 },
				{ 20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54 },
				{ 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48 }, };
		long answer = 0, down, right, downLeftDiag, downRightDiag;
		for (int line = 0; line < 20; line++)
			for (int col = 0; col < 20; col++) {
				down = 0;
				right = 0;
				downLeftDiag = 0;
				downRightDiag = 0;
				if (line <= 16) {
					if (col <= 16) {
						downRightDiag = matrix[line][col] * matrix[line + 1][col + 1] * matrix[line + 2][col + 2]
								* matrix[line + 3][col + 3];
					}
					if (col >= 3) {
						downLeftDiag = matrix[line][col] * matrix[line + 1][col - 1] * matrix[line + 2][col - 2]
								* matrix[line + 3][col - 3];
					}
					down = matrix[line][col] * matrix[line + 1][col] * matrix[line + 2][col] * matrix[line + 3][col];
				}
				if (col <= 16) {
					right = matrix[line][col] * matrix[line][col + 1] * matrix[line][col + 2] * matrix[line][col + 3];
				}
				answer = right > answer ? right
						: down > answer ? down
								: downRightDiag > answer ? downRightDiag
										: downLeftDiag > answer ? downLeftDiag : answer;
			}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println("The Euler Project");
		System.out.println("The answer for Problem 001 - Multiples of 3 and 5 is: " + Problem1.solution());
		System.out.println("The answer for Problem 002 - Fibonacci even Numbers is: " + Problem2.solution());
		System.out.println("The answer for Problem 003 - Largest prime factor is: " + Problem3.solution());
		System.out.println("The answer for Problem 004 - Largest palindrome product is: " + Problem4.solution());
		System.out.println("The answer for Problem 005 - Smallest multiple is: " + Problem5.solution());
		System.out.println("The answer for Problem 006 - Sum square difference is: " + problem6());
		System.out.println("The answer for Problem 007 - 10001st prime is: " + problem7());
		System.out.println("The answer for Problem 008 - Largest product in a series is: " + problem8());
		System.out.println("The answer for Problem 009 - Special Pythagorean triplet is: " + problem9());
		System.out.println("The answer for Problem 010 - Summation of primes is: " + problem10());
		System.out.println("The answer for Problem 011 - Largest product in a grid is: " + problem11());
	}

}
