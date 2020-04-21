package rompicapoNRegine;
import liste.StringSList;

/**
 * Soluzione del rompicapo delle N regine
 * 
 * @author zhouf
 *
 */

public class Queens {
	
	public static int numeroDiSoluzioni(int n) {
		return numeroDiCompletamenti(new Board(n));
	}	// method numeroDiSoluzioni
	
	public static StringSList listaDiSoluzioni2(int n) {
		return listaDiCompletamenti2(new Board(n));
	}	// method listaDiSoluzioni2
	
	public static BoardSList listaDiSoluzioni(int n) {
		BoardSList bl = new BoardSList();
		
		bl = bl.cons(listaDiCompletamenti(new Board(n)));
		
		return bl;
	}	// method listaDiSoluzioni
	
	public static StringSList listaDiCompletamenti2(Board b) {
		int n = b.size();
		int q = b.queensOn();
		
		if (q == n) {
			return (StringSList.NULL_STRINGLIST).cons(b.arrangement());
		} else {	// q < n
			int i = q + 1;
			StringSList sl = StringSList.NULL_STRINGLIST;
			
			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					sl = sl.append(listaDiCompletamenti2( b.addQueen(i, j) ));
				}
			}
			return sl;
		}
		
	}	// method listaDiCompletamenti
	
	public static Board listaDiCompletamenti(Board b) {
		int n = b.size();
		int q = b.queensOn();
		
		if ( q == n ) {
			return b;
		} else {
			int i = q + 1;
			
			for (int j = 1; j <= n; j++) {
				if ( !b.underAttack(i, j) ) {
					//i++;
					b = listaDiCompletamenti( b.addQueen(i, j) );
					System.out.println("numero regine: " + b.queensOn());
					System.out.println("config: " + b.arrangement());
				}
			}
			
			return b;
		}
	}	// method listaDiCompletamenti
	
	public static int numeroDiCompletamenti2(Board b) {
		int n = b.size();
		int q = b.queensOn();
		
		if (q == n) {
			return 1;
		} else {	// q < n
			int i = q + 1;
			int count = 0;
			
			for (int j = 1; j <= n; j++) {
				if (!b.underAttack(i, j)) {
					count = count + numeroDiCompletamenti( b.addQueen(i, j) );
				}
			}
			return count;
		}
		
	}	// method listaDiCompletamenti
	
	public static int numeroDiCompletamenti(Board b) {
		int n = b.size();
		int q = b.queensOn();
		int count = 0;
		int i = q;
		
		for (int j = 0; j < n; j++) {
			if ( !b.underAttack(i, j) ) {
				i = q + 1;
				count++;
				b.addQueen(i, j);
			}
		}
		return count;
		
	}	// method listaDiCompletamenti
	
	/*public static BoardSList listaDiBoard(int n) {
		Board b = new Board(n);
		//BoardSList bl = new BoardSList();
		//bl = bl.cons(listaDiSoluzioni(4).toString());
		
		int s = b.size();
		int q = b.queensOn();
		
		if (q == s) {
			return (BoardSList.NULL_BOARDLIST).cons(b);
		} else {	// q < n
			int i = q + 1;
			StringSList sl = StringSList.NULL_STRINGLIST;
			
			for (int j = 1; j <= s; j++) {
				if (!b.underAttack(i, j)) {
					sl = sl.append(listaDiCompletamenti( b.addQueen(i, j) ));
				}
			}
			return sl;
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Numero di soluzioni: " + listaDiSoluzioni(4));
	}	// method main

}	// class Queens

// es: avere una lista di board nello stile di scheme
// e quindi poi restituire direttamente una lista di scacchiere invece di una stringa di scacchiere