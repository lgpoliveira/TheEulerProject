package problems;

public class Problem3 {

	/**
	 * Largest prime factor
	 * 
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 60851475143 ?
	 **/
	public static long solution() {

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
}
