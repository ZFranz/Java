package programmazioneDinamica;

/* bottom up: prendiamo il controllo di tutte le procedure, senza usare ricorsioni, ma iterazione per iterazione
 * 
 */

public class ProgrammazioneDinamica {
	private static final int UNKNOWN = 0;
	private static final int UNKNOWNv2 = -1;
	private static final String UNKNOWNv3 = "";

	public static int fib(int n) { // n >= 0
		if (n < 2) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	} // method fib

	// int ha un limite per fib(46), mentre long raggiunge il limite a fib(92),
	// dopo tali valori va in overflow
	public static long fibMem(int n) { // n >= 0
		// inizializza h
		long[] h = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			h[i] = UNKNOWN;
		}

		return fibRec(n, h);
	} // method fibMem

	private static long fibRec(int n, long[] h) { // n >=0
		if (h[n] == UNKNOWN) { // se in h non è registrato già il valore di fib per n
			if (n < 2) {
				// registra in h il valore 1 per n
				h[n] = 1;
			} else {
				// registra in h il valore (fibREc(n - 2, h) + fibRec(n - 1, h)) per n
				h[n] = (fibRec(n - 2, h) + fibRec(n - 1, h));
			}
		}
		return h[n];// il valore registrato in h per n
	} // method fibRec

	public static int manh(int i, int j) { // i, j >= 0
		if ((i == 0) || (j == 0)) {
			return 1;
		} else {
			return manh(i - 1, j) + manh(i, j - 1);
		}
	} // method manh

	// ci saranno semrpe dei valori che vanno in overflow, manhRec(33, 34)
	public static long manhMem(int i, int j) { // i, j >= 0
		// inizializza h
		long[][] h = new long[i + 1][j + 1];
		for (int x = 0; x <= i; x++) {
			for (int y = 0; y <= j; y++) {
				h[x][y] = UNKNOWN;
			}
		}

		return manhRec(i, j, h);
	} // method manhMem

	private static long manhRec(int i, int j, long[][] h) { // i, j >= 0
		if (h[i][j] == UNKNOWN) {
			if ((i == 0) || (j == 0)) {
				h[i][j] = 1;
			} else {
				h[i][j] = manhRec(i - 1, j, h) + manhRec(i, j - 1, h);
			}
		}
		return h[i][j];
	} // method manhRec

	public static long fibDP(int n) { // n >= 0
		// inizializza h
		long[] h = new long[n + 1];
		// casi base
		h[0] = 1;
		if (h.length > 1) {
			h[1] = 1;
		}
		// casi >1
		for (int i = 2; i <= n; i++) {
			h[i] = h[i - 2] + h[i - 1];
		}
		return h[n];
	} // method fibDP

	public static long fibDPv2(int n) { // n >= 0
		// inizializza h
		long[] h = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i <= 1) { // caso base
				h[i] = 1;
			} else { // caso ricorsivo
				h[i] = h[i - 2] + h[i - 1];
			}
		}
		return h[n];
	} // method fibDPv2

	public static long manhDP(int i, int j) { // i, j >= 0
		// inizializza h
		long[][] h = new long[i + 1][j + 1];
		for (int y = 0; y <= j; y++) {
			h[0][y] = 1; // caso base
		}
		for (int x = 0; x <= i; x++) {
			h[x][0] = 1; // caso base
		}
		for (int x = 1; x <= i; x++) {
			for (int y = 1; y <= j; y++) {
				h[x][y] = h[x - 1][y] + h[x][y - 1];
				// non serve UNKNOWN, non ci chiediamo il valore che gli possedeva, ma
				// quella che vale
			}
		}
		return h[i][j];
	} // method manhDP

	public static long manhDPv2(int i, int j) { // i, j >= 0
		// inizializza h
		long[][] h = new long[i + 1][j + 1];
		for (int x = 0; x <= i; x++) {
			for (int y = 0; y <= j; y++) {
				if (x == 0 || y == 0) { // caso base
					h[x][y] = 1;
				} else { // caso ricorsivo
					h[x][y] = h[x - 1][y] + h[x][y - 1];
				}
				// non serve UNKNOWN, non ci chiediamo il valore che gli possedeva, ma
				// quella che vale
			}
		}
		return h[i][j];
	} // method manhDPv2

	public static int llcs(String u, String v) { // sottosequenza di stringa più lunga
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
	
	public static String llcsv2(String u, String v) { // sottosequenza di stringa più lunga
		int m = u.length();
		int n = v.length();

		if (m == 0 || n == 0) {
			return "";
		} else if (u.charAt(0) == v.charAt(0)) {
			return u.charAt(0) + llcsv2(u.substring(1), v.substring(1));
		} else {
			return better(llcsv2(u.substring(1), v), llcsv2(u, v.substring(1)));
		}
	} // method llcsv2

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
	
	public static String llcsMemv2(String u, String v) {
		int m = u.length();
		int n = v.length();

		// inizializza h
		String[][] h = new String[m + 1][n + 1];
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				h[x][y] = UNKNOWNv3;
			}
		}

		return llcsRecv2(u, v, h);
	} // method llcsMemv2

	private static String llcsRecv2(String u, String v, String[][] h) {
		int m = u.length();
		int n = v.length();

		if (h[m][n].equals(UNKNOWNv3)) { // se non l'ho già calcolato
			if (m == 0 || n == 0) {
				h[m][n] = "";
			} else if (u.charAt(0) == v.charAt(0)) {
				h[m][n] = u.charAt(0) + llcsRecv2(u.substring(1), v.substring(1), h);
			} else {
				h[m][n] = better(llcsRecv2(u.substring(1), v, h), llcsRecv2(u, v.substring(1), h));
			}
		}

		return h[m][n];
	} // method llcsRecv2

	public static void test() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("fibDP: Num di fibonacci di " + i + ": " + fibDPv2(i));
			System.out.println("fibMem: Num di fibonacci di " + i + ": " + fibMem(i));
		}
	} // method test

	public static void test2() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Numeri di percorsi di manhattan " + i + " * " + i + ": " + manhDPv2(i, i));
		}
		// System.out.println(" " + manhMem(10, 20));
	} // method test2

	public static void test3() {
		String s1 = "arto";
		String s2 = "atrio";
		System.out.println("llcs tra \"" + s1 + "\" e \"" + s2 + "\": " + llcsv2(s1, s2));
	} // method test3
	
	public static void test4() {
		String s1 = "abcabcabcabcabcabc";
		String s2 = "cbacbacbacbacbacba";
		System.out.println("llcs tra \"" + s1 + "\" e \"" + s2 + "\": " + llcsMemv2(s1, s2));
	} // method test4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	} // method main

} // class ProgrammazioneDinamica