package problems;

public class Problem4 {

	/**
	 * Largest palindrome product
	 * 
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 × 99. Find the
	 * largest palindrome made from the product of two 3-digit numbers.
	 */
	public static long solution() {
		long answer = 0;
		for (int i = 999; i > 99; i--)
			for (int j = 998; j > 99; j--) {
				long temp = i * j;
				StringBuffer tmp = new StringBuffer(String.valueOf(temp));
				if (tmp.toString().equals(tmp.reverse().toString()) && temp > answer) {
					answer = temp;
				}
			}
		return answer;
	}

}
