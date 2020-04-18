package rompicapoNRegine;
import java.util.function.*;

/**
 * Protocollo della classe "Board":
 * 
 * Board b = new Board(n);
 * 
 * b.size()				: int
 * b.queensOn()			: int
 * b.underAttack(i,j)	: boolean
 * b.arrangement()		: String
 * 
 * b.addQueen(i,j)		: Board
 * 
 */

public class Board {
	
	private static final String ROWS = " 123456789ABCDEF";
	private static final String COLS = " abcdefghijklmno";
	
	private final int size;
	private final int queens;
	private final BiPredicate<Integer, Integer> attack; // predicato per vedere se una regina è minacciata
	private final String config;	// configurazione, disposizione delle regine
	
	public Board( int n ) {
		size = n;
		queens = 0;
		attack = ( x, y ) -> false;	// (lambda (x y) false)
		config = "";
	}	// constructor Board vuoto
	
	private Board( int n, int q, BiPredicate<Integer, Integer> p, String c ) {
		size = n;
		queens = q;
		attack = p;	// (lambda (x y) false)
		config = c;
	}	// constructor Board non vuoto
	
	public int size() {	// dimensione della scacchiera
		return size;
	}	//method size
	
	public int queensOn() {	// quante regine ci sono
		return queens;
	}	//method queensOn
	
	public boolean underAttack( int i, int j ) {	// controllo se una regina viene attaccata da un'altra regina
		return attack.test( i, j );	// (attack i j)
	}	// method underAttack
	
	public String arrangement() {
		return config;
	}	// method arrangement
	
	public Board addQueen( int i, int j ) {
		return new Board(
				size,
				queens + 1,
				( x, y ) -> ( (x == i) || (y == j) || (x-y == i-j) || (x+y == i+j) || attack.test(x, y) ),
				config + " " + COLS.substring( j,  j+1 ) + ROWS.substring( i, i+1 ) + " "
				);
	}	// method addQueen
	
}	// class Board