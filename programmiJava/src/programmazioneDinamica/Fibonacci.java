package programmazioneDinamica;

public class Fibonacci {

	private static final int UNKNOWN = 0;

	/**
	 * 
	 * @param n - Integer >=0
	 * @return - Fibonacci's number at "n" position using recursion
	 */
	public static int fib(int n) { // n >= 0
		if (n < 2) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	} // method fib

	/**
	 * 
	 * @param n - Integer >=0
	 * @param h - Long vector
	 * @return - Fibonacci's number at "n" position using memorization
	 * 
	 *         int ha un limite per fib(46), mentre long raggiunge il limite a
	 *         fib(92), dopo tali valori va in overflow
	 */
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

	/**
	 * 
	 * @param n - Integer >=0
	 * @param h - Long vector
	 * @return - Fibonacci's number at "n" position using bottom-up
	 */
	public static long fibBottomUp(int n) { // n >= 0
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

	/**
	 * 
	 * @param n - Integer >=0
	 * @param h - Long vector
	 * @return - Fibonacci's number at "n" position using bottom-up
	 */
	public static long fibBottomUpv2(int n) { // n >= 0
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 100; i++) {
			System.out.println("fibDP: Num di fibonacci di " + i + ": " + fibBottomUp(i));
			System.out.println("fibMem: Num di fibonacci di " + i + ": " + fibMem(i));
		}
	}

}
