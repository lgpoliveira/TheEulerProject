package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {

	/**
	 * 10001st prime 
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and
	 * 13, we can see that the 6th prime is 13. What is the 10 001st prime
	 * number?
	 */
	public static long solution() {
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
}
