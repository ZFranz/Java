package programmazioneDinamica;

public class Llcs {

	private static final int UNKNOWNv2 = -1;
	private static final String UNKNOWNv3 = "";

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - the longer String
	 */
	private static String better(String u, String v) {
		int m = u.length();
		int n = v.length();

		if (m < n) {
			return v;
		} else if (n < m) {
			return u;
		} else if ((Math.random() * 2) == 0) {
			return v;
		} else {
			return u;
		}
	} // method better

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - length of the longest common subsequence using recursion
	 */
	public static int llcs(String u, String v) {
		int m = u.length();
		int n = v.length();

		if (m == 0 || n == 0) {
			return 0;
		} else if (u.charAt(0) == v.charAt(0)) {
			return 1 + llcs(u.substring(1), v.substring(1));
		} else {
			return Math.max(llcs(u.substring(1), v), llcs(u, v.substring(1)));
		}
	} // method llcs

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - longest common subsequence using recursion
	 */
	public static String lcs(String u, String v) {
		int m = u.length();
		int n = v.length();

		if (m == 0 || n == 0) {
			return "";
		} else if (u.charAt(0) == v.charAt(0)) {
			return u.charAt(0) + lcs(u.substring(1), v.substring(1));
		} else {
			return better(lcs(u.substring(1), v), lcs(u, v.substring(1)));
		}
	} // method lcs

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - length of the longest common subsequence using memorization
	 */
	public static int llcsMem(String u, String v) {
		int m = u.length();
		int n = v.length();

		// inizializza h
		int[][] h = new int[m + 1][n + 1];
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				h[x][y] = UNKNOWNv2;
			}
		}

		return llcsRec(u, v, h);
	} // method llcsMem

	private static int llcsRec(String u, String v, int[][] h) {
		int m = u.length();
		int n = v.length();

		if (h[m][n] == UNKNOWNv2) { // se non l'ho già calcolato
			if (m == 0 || n == 0) {
				h[m][n] = 0;
			} else if (u.charAt(0) == v.charAt(0)) {
				h[m][n] = 1 + llcsRec(u.substring(1), v.substring(1), h);
			} else {
				h[m][n] = Math.max(llcsRec(u.substring(1), v, h), llcsRec(u, v.substring(1), h));
			}
		}

		return h[m][n];
	} // method llcsRec

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - longest common subsequence using memorization
	 */
	public static String lcsMem(String u, String v) {
		int m = u.length();
		int n = v.length();

		// inizializza h
		String[][] h = new String[m + 1][n + 1];
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				h[x][y] = UNKNOWNv3;
			}
		}

		return lcsRec(u, v, h);
	} // method lcsMem

	private static String lcsRec(String u, String v, String[][] h) {
		int m = u.length();
		int n = v.length();

		if (h[m][n].equals(UNKNOWNv3)) { // se non l'ho già calcolato
			if (m == 0 || n == 0) {
				h[m][n] = "";
			} else if (u.charAt(0) == v.charAt(0)) {
				h[m][n] = u.charAt(0) + lcsRec(u.substring(1), v.substring(1), h);
			} else {
				h[m][n] = better(lcsRec(u.substring(1), v, h), lcsRec(u, v.substring(1), h));
			}
		}

		return h[m][n];
	} // method lcsRec

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - length of the longest common subsequence using bottom-up
	 */
	private static int llcsBottomUp(String u, String v) {
		int m = u.length();
		int n = v.length();
		int[][] h = new int[m + 1][n + 1];

		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				if (x == 0 || y == 0) {
					h[x][y] = 0;
				} else if (u.charAt(m - x) == v.charAt(n - y)) {
					h[x][y] = 1 + h[x - 1][y - 1];
				} else {
					h[x][y] = Math.max(h[x - 1][y], h[x][y - 1]);
				}
			}
		}

		return h[m][n];
	} // method llcsBottomUp

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - longest common subsequence using bottom-up
	 */
	private static String lcsBottomUp(String u, String v) {
		int m = u.length();
		int n = v.length();
		String[][] h = new String[m + 1][n + 1];

		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				if (x == 0 || y == 0) {
					h[x][y] = "";
				} else if (u.charAt(m - x) == v.charAt(n - y)) {
					h[x][y] = u.charAt(m - x) + h[x - 1][y - 1];
				} else {
					h[x][y] = better(h[x - 1][y], h[x][y - 1]);
				}
			}
		}

		return h[m][n];
	} // method lcsBottomUp

	/**
	 * 
	 * @param u - String
	 * @param v - String
	 * @return - longest common subsequence using bottom-up reverse
	 */
	private static String lcsBottomUpReverse(String u, String v) {
		int m = u.length();
		int n = v.length();
		int[][] h = new int[m + 1][n + 1];

		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				if (x == 0 || y == 0) {
					h[x][y] = 0;
				} else if (u.charAt(m - x) == v.charAt(n - y)) {
					h[x][y] = 1 + h[x - 1][y - 1];
				} else {
					h[x][y] = Math.max(h[x - 1][y], h[x][y - 1]);
				}
			}
		}

		String s = "";
		int i = m;
		int j = n;

		while ((i > 0) && (j > 0)) {
			if (u.charAt(m - i) == v.charAt(n - j)) {
				s = s + u.charAt(m-i);
				i--;
				j--;
			} else if(h[i-1][j] < h[i][j-1]) {
				j--;
			} else if(h[i-1][j] > h[i][j-1]) {
				i--;
			} else if(Math.random() < 0.5) {
				j--;
			} else {
				i--;
			}
		}

		return s;
	} // method lcsBottomUpReverse

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String s1 = "arto";
		String s2 = "atrio";
		String s3 = "abcabcabcabcabcabc";
		String s4 = "cbacbacbacbacbacba";
		System.out.println("llcs tra \"" + s1 + "\" e \"" + s2 + "\": " + llcsBottomUp(s1, s2));
		System.out.println("lcs tra \"" + s1 + "\" e \"" + s2 + "\": " + lcsBottomUp(s1, s2));
		System.out.println("lcs reverse tra \"" + s1 + "\" e \"" + s2 + "\": " + lcsBottomUpReverse(s1, s2));
		System.out.println("llcs tra \"" + s3 + "\" e \"" + s4 + "\": " + llcsBottomUp(s3, s4));
		System.out.println("lcs tra \"" + s3 + "\" e \"" + s4 + "\": " + lcsBottomUp(s3, s4));
	} // method main
} // class Llcs
