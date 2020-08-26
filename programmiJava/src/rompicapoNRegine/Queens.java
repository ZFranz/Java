package rompicapoNRegine;

import lab.stringSList.StringSList;

/**
 * Soluzione del rompicapo delle N regine
 * 
 * @author zhouf
 *
 */

public class Queens {

	public static int numeroDiSoluzioni(int n) {
		return numeroDiCompletamenti(new Board(n));
	} // method numeroDiSoluzioni

	public static StringSList listaDiSoluzioni(int n) {
		return listaDiCompletamenti(new Board(n));
	} // method listaDiSoluzioni
	
	public static int numeroDiSoluzioniv2(int n) {
		return numeroDiCompletamentiv2(new Board2(n));
	} // method numeroDiSoluzioni

	public static StringSList listaDiSoluzioniv2(int n) {
		return listaDiCompletamentiv2(new Board2(n));
	} // method listaDiSoluzioni2

	public static StringSList listaDiCompletamenti(Board b) {
		int n = b.size();
		int q = b.queensOn();

		if (q == n) {
			return (StringSList.NULL_STRINGLIST).cons(b.arrangement());
		} else { // q < n
			int i = q + 1;
			StringSList sl = StringSList.NULL_STRINGLIST;

			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					sl = sl.append(listaDiCompletamenti(b.addQueen(i, j)));
				}
			}
			return sl;
		}

	} // method listaDiCompletamenti

	public static int numeroDiCompletamenti(Board b) {
		int n = b.size();
		int q = b.queensOn();

		if (q == n) {
			return 1;
		} else { // q < n
			int i = q + 1;
			int count = 0;

			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					count = count + numeroDiCompletamenti(b.addQueen(i, j));
				}
			}
			return count;
		}

	} // method numeroDiCompletamenti
	
	public static StringSList listaDiCompletamentiv2(Board2 b) {
		int n = b.size();
		int q = b.queensOn();

		if (q == n) {
			return (StringSList.NULL_STRINGLIST).cons(b.arrangement());
		} else { // q < n
			int i = q + 1;
			StringSList sl = StringSList.NULL_STRINGLIST;

			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					b.addQueen(i, j);
					sl = sl.append(listaDiCompletamentiv2(b));
					b.removeQueen(i,  j);
				}
			}
			return sl;
		}

	} // method listaDiCompletamentiv2
	
	public static int numeroDiCompletamentiv2(Board2 b) {
		int n = b.size();
		int q = b.queensOn();

		if (q == n) {
			return 1;
		} else { // q < n
			int i = q + 1;
			int count = 0;

			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					b.addQueen(i, j);
					count = count + numeroDiCompletamentiv2(b);
					b.removeQueen(i, j);
				}
			}
			return count;
		}

	} // method numeroDiCompletamentiv2

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Numero di soluzioni: " + numeroDiSoluzioniv2(8));
		System.out.println("Numero di soluzioni: " + listaDiSoluzioniv2(4));
	} // method main

} // class Queens

// es: avere una lista di board nello stile di scheme
// e quindi poi restituire direttamente una lista di scacchiere invece di una stringa di scacchiere