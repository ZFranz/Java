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

	
	public static int llisMem(int[] s) {
		int n = s.length;
		int[][] h = new int[n+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				h[i][j] = UNKNOWN;
			}
		}
		return llisMemRec(s, 0, 0, h);
	}
	/**
	 * 
	 * @param s - Vector
	 * @return - length of the longest increasing subsequence using memorization
	 * 
	 *         s[i] > 0 per i in [0,n-1], dove n = s.length
	 */
	public static int llisMemRec(int[] s, int i, int j, int[][] h) {
		final int n = s.length;
		int[] p = new int [n + 1];
		int t = p[j];

		if (i == n) {
			h[i][j] = 0;
		} else if (s[i] <= t) {
			h[i][j] = llisMemRec(s, i + 1, j, h);
		} else {
			h[i][j] = Math.max(1 + llisMemRec(s, i + 1, s[i], h), llisMemRec(s, i + 1, t, h));
		}

		return h[i][j];
	} // llisMem

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(llisMem(new int[] { 47, 38, 39, 25, 44 }));

		System.out.println(llis(new int[] { 5, 4, 3, 2, 1 }));
	} // method main
} // class Llis
