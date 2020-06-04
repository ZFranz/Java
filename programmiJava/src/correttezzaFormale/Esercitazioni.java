package correttezzaFormale;

import java.util.*;

public class Esercitazioni {
	private static final String[] UNKNOWN = null;

	public static String[] diff(String u, String v) {
		if (u.equals("") || v.equals("")) {
			return new String[] { u, v };
		} else if (u.charAt(0) == v.charAt(0)) {
			return diff(u.substring(1), v.substring(1));
		} else {
			String[] x = diff(u.substring(1), v);
			String[] y = diff(u, v.substring(1));

			if (x[0].length() < y[0].length()) {
				return new String[] { u.charAt(0) + x[0], x[1] };
			} else {
				return new String[] { y[0], v.charAt(0) + x[1] };
			}
		}
	} // method diff
	
	public static String[] diffMem(String u, String v) {
		int m = u.length(), n = v.length();
		String[][][] h = new String[m + 1][n + 1][];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				h[i][j] = UNKNOWN;
			}
		}
		
		return diffRec(u, v, h);
	} // method diffMem

	/**
	 * 
	 * @param u
	 * @param v
	 * @param h - matrice di coppie -> matrice di array, le prime due dimensioni sono le coordinate
	 * 								   la terza dimensione contiene quello che viene restituito
	 * @return
	 */
	public static String[] diffRec(String u, String v, String[][][] h) {
		int i = u.length(), j = v.length();

		if (h[i][j] == UNKNOWN) {
			if (u.equals("") || v.equals("")) {
				h[i][j] = new String[] { u, v };
			} else if (u.charAt(0) == v.charAt(0)) {
				h[i][j] = diff(u.substring(1), v.substring(1));
			} else {
				String[] x = diff(u.substring(1), v);
				String[] y = diff(u, v.substring(1));

				if (x[0].length() < y[0].length()) {
					h[i][j] = new String[] { u.charAt(0) + x[0], x[1] };
				} else {
					h[i][j] = new String[] { y[0], v.charAt(0) + x[1] };
				}
			}
		}

		return h[i][j];
	} // method diffRec
	
	
	public static long st(int n, int k) { // n, k > 0
		long[] cn = new long[] { 0 }; // contatore: variabile di stato
		sRec(1, n, k, cn);
		return cn[0];
	} // method st

	private static void sRec(int p, int n, int k, long[] cn) {
		if ((k == 1) || (k == n)) {
			cn[0] = cn[0] + p;
		} else {
			sRec(p, n - 1, k - 1, cn);
			sRec(k * p, n - 1, k, cn);
		}
	} // method sRec

	public static long stIter(int n, int k) {
		long[] cn = new long[] { 0 };
		Stack<int[]> stack = new Stack<int[]>();

		int[] f = new int[] { 1, n, k };
		stack.push(f);

		while (!stack.empty()) { // continua finché lo stack non è vuoto
			f = stack.pop();

			if ((f[2] == 1) || (f[2] == f[1])) {
				cn[0] = cn[0] + f[0];
			} else { // si inverte l'ordine delle operazioni da svolgere, nel modo iterativo
				stack.push(new int[] { f[2] * f[0], f[1] - 1, f[2] });
				stack.push(new int[] { f[0], f[1] - 1, f[2] - 1 });
			}
		}

		return cn[0];
	} // method stIter

	public static void main(String[] args) {
		String s1 = "arto";
		String s2 = "atrio";
		String[] h = diffMem(s1, s2);
		for (int i = 0; i < h.length; i++) {
			System.out.println(h[i]);
		}
		
		int n = 6;
		int k = 3; 
		System.out.println(st(n, k));
		System.out.println(stIter(n, k));
	} // method main

}
