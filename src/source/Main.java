package source;

import java.util.ArrayList;
import java.util.List;

import problems.Problem1;
import problems.Problem2;
import problems.Problem3;
import problems.Problem4;
import problems.Problem5;
import problems.Problem6;
import problems.Problem7;
import problems.Problem8;

//TODO: Refactor the main class and put each problem method in a separate class
public class Main {

	




	

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
		System.out.println("The answer for Problem 006 - Sum square difference is: " + Problem6.solution());
		System.out.println("The answer for Problem 007 - 10001st prime is: " + Problem7.solution());
		System.out.println("The answer for Problem 008 - Largest product in a series is: " + Problem8.solution());
		System.out.println("The answer for Problem 009 - Special Pythagorean triplet is: " + problem9());
		System.out.println("The answer for Problem 010 - Summation of primes is: " + problem10());
		System.out.println("The answer for Problem 011 - Largest product in a grid is: " + problem11());
		System.out.println("==============================================================================");
		
	}

}
