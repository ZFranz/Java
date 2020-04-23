package programmazioneDinamica;

public class ProgrammazioneDinamica {
	private static final int UNKNOWN = 0;

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
	} // method fibMem

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

	public static void test() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Num di fibonacci di " + i + ": " + fibMem(i));
		}
	} // method test

	public static void test2() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Numeri di percorsi di manhattan " + i + " * " + i + ": " + manhMem(i, i));
		}
		//System.out.println(" " + manhMem(10, 20));
	} // method test2

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	} // method main

} // class ProgrammazioneDinamica