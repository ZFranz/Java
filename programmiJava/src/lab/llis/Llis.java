package lab.llis;

import liste.IntSList;
import java.util.Arrays;

public class Llis {

	// Variabile di classe
    private static final int UNKNOWN = 0;

    /**
     * Length of the longest increasing subsequence
     * (recursive)
     *
     * @param s an array of Integers
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    public static int llis(int[] s) {
        return llisRec(s, 0, 0);
    }

    /**
     * Length of the longest increasing subsequence
     * Versione ricorsiva
     *
     * @param s an array of Integers
     * @param i an index
     * @param t an index
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    private static int llisRec(int[] s, int i, int t) {
        final int n = s.length;
        if (i == n) {
            return 0;

        } else if (s[i] <= t) {
            return llisRec(s, i + 1, t);

        } else {
            return Math.max(1 + llisRec(s, i + 1, s[i]), llisRec(s, i + 1, t));
        }
    }

    /**
     * Length of the longest increasing subsequence
     * (memoization)
     *
     * @param s an array of Integers
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    public static int llisMemoization(int[] s) {
        final int n = s.length;
        final int[][] h = new int[n + 1][n + 1];
        int[] b = Arrays.copyOf(s, n + 1); // b: {3, 10, 2, 1, 20, 0} -> 0 in ultima posizione

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llisMem(b, 0, n, h);
    }

    /**
     * Length of the longest increasing subsequence
     * Versione memoization
     *
     * @param s an array of Integers
     * @param i an index
     * @param j an index
     * @param h an array to store the values
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    private static int llisMem(int[] s, int i, int j, int[][] h) {
        final int n = s.length - 1; // 5

        int t = s[j];

        if (i == n) {
            h[i][j] = 0;

        } else if (s[i] <= t) {
            h[i][j] = llisMem(s, i + 1, j, h);

        } else {
            h[i][j] = Math.max(1 + llisMem(s, i + 1, i, h), llisMem(s, i + 1, j, h));

        }

        return h[i][j];
    }

    /**
     * Longest increasing subsequence
     * Versione memoization
     *
     * @param s an array of Integers
     * @return la lista con la più lunga sottosequenza di s strettamente crescente
     */
    public static IntSList lis(int[] s) {
        final int n = s.length;
        final IntSList[][] h = new IntSList[n + 1][n + 1];
        int[] b = Arrays.copyOf(s, n + 1); // b: {3, 10, 2, 1, 20, 0} -> 0 in ultima posizione

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = IntSList.NULL_INTLIST;
            }
        }

        return lisMem(b, 0, n, h);
    }

    /**
     * Procedura di supporto per longest increasing subsequence
     * Versione memoization
     *
     * @param s an array of Integers
     * @param i an index
     * @param j an index
     * @param h una lista per memorizzare i valori ottenuti
     * @return la lista con la più lunga sottosequenza di s strettamente crescente
     */
    private static IntSList lisMem(int[] s, int i, int j, IntSList[][] h) {
        final int n = s.length - 1; // 5

        int t = s[j];

        if (i == n) {
            h[i][j] = IntSList.NULL_INTLIST;

        } else if (s[i] <= t) {
            h[i][j] = lisMem(s, i + 1, j, h);

        } else {
            h[i][j] = longer(lisMem(s, i + 1, i, h).cons(s[i]), lisMem(s, i + 1, j, h));

        }

        return h[i][j];
    }

    /**
     * Procedura di supporto per calcolare lista più lunga tra IntSList a e IntSList b
     *
     * @param a una lista di Integers
     * @param b una lista di Integers
     * @return la lista di lunghezza maggiore tra a e b
     */
    private static IntSList longer(IntSList a, IntSList b) {
        int m = a.length();
        int n = b.length();

        if (m < n) {
            return b;

        } else if (m > n) {
            return a;

        } else if (Math.random() < 0.5) {
            return b;

        } else {
            return a;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Calcola la lunghezza della più lunga sottosequenza di s strettamente crescente (Versione Ricorsiva)
        System.out.println("Versione ricorsiva: ");
        System.out.println(llis(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llis(new int[]{3, 10, 2, 1, 20})); // 3
        System.out.println(llis(new int[]{7, 38, 39, 25, 44})); // 4
        System.out.println(llis(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // 4
        System.out.println(llis(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llis(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3

        // Calcola la lunghezza della più lunga sottosequenza di s strettamente crescente (Versione Memoization)
        System.out.println("Versione memoization: ");
        System.out.println(llisMemoization(new int[]{3, 10, 2, 1, 20})); // 3
        System.out.println(llisMemoization(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llisMemoization(new int[]{47, 38, 39, 25, 44})); // 3
        System.out.println(llisMemoization(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // 4
        System.out.println(llisMemoization(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llisMemoization(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3
        System.out.println(llisMemoization(new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(llisMemoization(new int[]{5, 4, 8})); // 2
        System.out.println(llisMemoization(new int[]{50, 3, 10, 7, 40, 80})); // 4
        System.out.println(llisMemoization(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})); // 6
        System.out.println(llisMemoization(new int[]{3, 5, 2, 1, 7, 4, 8, 3, 9})); // (3, 5, 7, 8, 9)

        // Visualizza la lista della più lunga sottosequenza di s strettamente crescente
        System.out.println("List of longest increasing subsequence: ");
        System.out.println(lis(new int[]{5, 4, 3, 2, 1})); // (5)
        System.out.println(lis(new int[]{5, 4, 8})); // (5, 8)
        System.out.println(lis(new int[]{3, 10, 2, 1, 20})); // (3, 10, 20)
        System.out.println(lis(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // (7, 29, 49, 53)
        System.out.println(lis(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // (9, 46, 54, 60, 61)
        System.out.println(lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})); // (10, 22, 33, 50, 60, 80)
        System.out.println(lis(new int[]{3, 5, 2, 1, 7, 4, 8, 3, 9}));
	}

}
