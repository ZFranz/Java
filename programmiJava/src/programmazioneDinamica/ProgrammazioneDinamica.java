package programmazioneDinamica;

public class ProgrammazioneDinamica {
	private static final int UNKNOWN = 0;

	public static int fib(int n) { // n>=0
		if (n < 2) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	} // method fib

	public static int fibMem(int n) { // n>=0
		// inizializza h
		int[] h = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			h[i] = UNKNOWN;
		}

		return fibRec(n, h);
	}

	public static int fibRec(int n, int[] h) { // n>=0
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 60; i++) {
			System.out.println("Num di fibonacci di " + i + ": " + fibMem(i));
		}
	} // main

} // class ProgrammazioneDinamica