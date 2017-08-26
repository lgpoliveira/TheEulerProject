package problems;

public class Problem5 {

	/**
	 * Smallest multiple 2520
	 * 
	 * is the smallest number that can be divided by each of the numbers from 1
	 * to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 */
	public static long solution() {
		long answer = 20;
		while (answer % 2 != 0 || answer % 3 != 0 || answer % 4 != 0 || answer % 5 != 0 || answer % 6 != 0
				|| answer % 7 != 0 || answer % 8 != 0 || answer % 9 != 0 || answer % 10 != 0 || answer % 11 != 0
				|| answer % 12 != 0 || answer % 13 != 0 || answer % 14 != 0 || answer % 15 != 0 || answer % 16 != 0
				|| answer % 17 != 0 || answer % 18 != 0 || answer % 19 != 0 || answer % 20 != 0) {
			answer += 20;
		}
		return answer;
	}
}
