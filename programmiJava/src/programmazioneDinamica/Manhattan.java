package programmazioneDinamica;

public class Manhattan {

	private static final int UNKNOWN = 0;

	/**
	 * 
	 * @param i - Integer >=0
	 * @param j - Integer >=0
	 * @return - numero di percorsi di Manhattan using recursion
	 */
	public static int manh(int i, int j) { // i, j >= 0
		if ((i == 0) || (j == 0)) {
			return 1;
		} else {
			return manh(i - 1, j) + manh(i, j - 1);
		}
	} // method manh

	/**
	 * 
	 * @param i - Integer >=0
	 * @param j - Integer >=0
	 * @param h - Long matrice[i+1][j+1]
	 * @return - numero di percorsi di Manhattan using memorization
	 * 
	 *         ci saranno sempre dei valori che vanno in overflow, manhRec(33, 34)
	 */
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

	/**
	 * 
	 * @param i - Integer >=0
	 * @param j - Integer >=0
	 * @param h - Long matrice[i+1][j+1]
	 * @return - numero di percorsi di Manhattan using bottom-up
	 */
	public static long manhBottomUp(int i, int j) { // i, j >= 0
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
	} // method manhBottomUp

	/**
	 * 
	 * @param i - Integer >=0
	 * @param j - Integer >=0
	 * @param h - Long matrice[i+1][j+1]
	 * @return - numero di percorsi di Manhattan using bottom-up
	 */
	public static long manhBottomUpv2(int i, int j) { // i, j >= 0
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
	} // method manhBottomUpv2

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 10; i++) {
			System.out.println("Numeri di percorsi di manhattan " + i + " * " + i + ": " + manhBottomUp(i, i));
		}
	}

}
