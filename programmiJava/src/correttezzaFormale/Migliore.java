package correttezzaFormale;

public class Migliore {

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

	public static String migliore(String w, String[] ws) {
		int n = ws.length;
		int y = llcs(ws[0], w);
		int k = 0;

		for (int i = 0; i < n; i++) {
			int x = llcs(ws[i], w);
			if (x > y) {
				y = x;
				k = i;
			}
		}

		return ws[k];
	} // method migliore

	public static void main(String[] args) {
		String w = "tuscania";
		String[] ws = new String[] { "bevagna", "pitigliano", "saturnia", "trevi", "vitorchiano" };
		System.out.println(migliore(w, ws));
	} // method main

} // class Migliore
