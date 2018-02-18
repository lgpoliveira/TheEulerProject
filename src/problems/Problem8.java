package problems;

public class Problem8 {

	/**
	 * Largest product in a series
	 * 
	 * The four adjacent digits in the 1000-digit number that have the greatest
	 * product are 9 × 9 × 8 × 9 = 5832. Find the thirteen adjacent digits in
	 * the 1000-digit number that have the greatest product. What is the value
	 * of this product?
	 */
	public static long solution() {
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
}
