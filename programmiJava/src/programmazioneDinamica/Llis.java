package programmazioneDinamica;

public class Llis {

	private static final int UNKNOWN = 0;

	/**
	 * 
	 * @param s - Vector
	 * @return - length of the longest increasing subsequence using recursion
	 * 
	 *         s[i] > 0 per i in [0,n-1], dove n = s.length
	 */
	public static int llis(int[] s) {
		return llisRec(s, 0, 0);
	} // method llis

	/**
	 * 
	 * @param s - Vector
	 * @param i - Integer
	 * @param t - Integer, temporal variable
	 * @return - length of the longest increasing subsequence using recursion
	 */
	public static int llisRec(int[] s, int i, int t) {
		final int n = s.length;
		if (i == n) {
			return 0;
		} else if (s[i] <= t) {
			return llisRec(s, i + 1, t);
		} else {
			return Math.max(1 + llisRec(s, i + 1, s[i]), llisRec(s, i + 1, t));
		}
	} // method llisRec

	/**
	 * 
	 * @param s - Vector
	 * @return - length of the longest increasing subsequence using memorization
	 * 
	 *         s[i] > 0 per i in [0,n-1], dove n = s.length
	 */
	public static int llisMem(int[] s) {
		int n = s.length;

		int[][] h = new int[1][n];
		for (int x = 0; x < n; x++) {
			h[0][x] = s[x];
		}

		return llisMemRec(n, 0, 0, h);
	} // llisMem

	public static int llisMemRec(int n, int i, int j, int[][] h) {

		if (i == n) {
			return 0;
		} else if (h[0][i] <= h[0][j]) {
			return llisMemRec(n, i + 1, j, h);
		} else if (h[0][i] > h[0][j]) {
			return 1 + llisMemRec(n, i + 1, i, h);
		} else {
			return Math.max(1 + llisMemRec(n, i + 1, h[0][i], h), llisMemRec(n, i + 1, h[0][j], h));
		}

	} // llisMemRec

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		llisMem(new int[] { 5, 4, 3, 2, 1 });
		System.out.println(llisMem(new int[] { 47, 38, 39, 25, 44 }));

		System.out.println(llis(new int[] { 5, 4, 3, 2, 1 }));
	} // method main
} // class Llis
