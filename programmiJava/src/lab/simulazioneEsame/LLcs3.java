package lab.simulazioneEsame;

public class LLcs3 {
	private static final int UNKNOWN = -1;

	public static int llcs3Mem(String t, String u, String v) {
		int m = t.length();
		int n = u.length();
		int o = v.length();
		int[][][] h = new int[m + 1][n + 1][o + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= o; k++) {
					h[i][j][k] = UNKNOWN;
				}
			}
		}

		return llcs3Rec(t, u, v, h);
	} // method llcs3Mem

	public static int llcs3Rec(String t, String u, String v, int[][][] h) {
		int m = t.length();
		int n = u.length();
		int o = v.length();

		if (h[m][n][o] == UNKNOWN) {
			if (m == 0 || n == 0 || o == 0) {
				h[m][n][o] = 0;
			} else if ((t.charAt(0) == u.charAt(0)) && (t.charAt(0) == v.charAt(0))) {
				h[m][n][o] = 1 + llcs3Rec(t.substring(1), u.substring(1), v.substring(1), h);
			} else {
				h[m][n][o] = Math.max(llcs3Rec(t.substring(1), u, v, h),
						Math.max(llcs3Rec(t, u.substring(1), v, h), llcs3Rec(t, u, v.substring(1), h)));
			}
		}

		return h[m][n][o];
	} // method llcs3Rec

	public static int llcs3(String t, String u, String v) {
		if (t.equals("") || u.equals("") || v.equals("")) {
			return 0;
		} else if ((t.charAt(0) == u.charAt(0)) && (t.charAt(0) == v.charAt(0))) {
			return 1 + llcs3(t.substring(1), u.substring(1), v.substring(1));
		} else {
			return Math.max(llcs3(t.substring(1), u, v),
					Math.max(llcs3(t, u.substring(1), v), llcs3(t, u, v.substring(1))));
		}
	} // method Llcs3

	public static void main(String[] args) {
		String s1 = "arto";
		String s2 = "arto";
		String s3 = "arto";
		System.out.println(llcs3(s1, s2, s3));
		System.out.println(llcs3Mem(s1, s2, s3));

	} // method main

}
