package rompicapoNRegine;

import java.util.function.*;

/**
 * Protocollo della classe "Board":
 * 
 * Board b = new Board(n);
 * 
 * b.size()            : int 
 * b.queensOn()        : int 
 * b.underAttack(i,j)  : boolean
 * b.arrangement()     : String
 * 
 * b.addQueen(i,j);
 * b.removeQueen(i,j);
 * 
 */

public class Board2 {

	private static final String ROWS = " 123456789ABCDEF";
	private static final String COLS = " abcdefghijklmno";

	private final int size;
	private int queens;
	private int[] rowAttack; // mi chiedo se una certa riga è sottoscacco
	private int[] colAttack; // mi chiedo se una certa colonna è sottoscacco
	private int[] dg1Attack; // mi chiedo se la diagonale in basso a destra è sottoscacco
	private int[] dg2Attack; // mi chiedo se la diagonale in alto a destra è sottoscacco
	private String config; // configurazione, disposizione delle regine

	public Board2(int n) {
		size = n;
		queens = 0;
		rowAttack = newArray(n);
		colAttack = newArray(n);
		dg1Attack = newArray(2 * n - 1);
		dg2Attack = newArray(2 * n - 1);
		config = "";
	} // constructor Board
	
	// ----- Procedura di supporto al costruttore
	private static int[] newArray(int k) {
		int[] v = new int[k];
		for (int i = 0; i < k; i++) {
			v[i] = 0;
		}
		return v;
	}

	public int size() { // dimensione della scacchiera
		return size;
	} // method size

	public int queensOn() { // quante regine ci sono
		return queens;
	} // method queensOn

	public boolean underAttack(int i, int j) { // controllo se una regina viene attaccata da un'altra regina
		return ((rowAttack[i - 1] > 0) || 
				(colAttack[j - 1] > 0) || 
				(dg1Attack[i - j + size - 1] > 0) || 
				(dg2Attack[i + j - 2] > 0));
	} // method underAttack

	public String arrangement() {
		return config;
	} // method arrangement

	public void addQueen(int i, int j) {
		queens = queens + 1;
		rowAttack[i - 1] = rowAttack[i - 1] + 1;
		colAttack[j - 1] = colAttack[j - 1] + 1;
		dg1Attack[i - j + size - 1] = dg1Attack[i - j + size - 1] + 1;
		dg2Attack[i + j - 2] = dg2Attack[i + j - 2] + 1;
		config = config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ";
	} // method addQueen
	
	public void removeQueen(int i, int j) {
		queens = queens - 1;
		rowAttack[i - 1] = rowAttack[i - 1] - 1;
		colAttack[j - 1] = colAttack[j - 1] - 1;
		dg1Attack[i - j + size - 1] = dg1Attack[i - j + size - 1] - 1;
		dg2Attack[i + j - 2] = dg2Attack[i + j - 2] - 1;
		String pos = " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ";
		int k = config.indexOf(pos);
		config = config.substring(0, k) + config.substring(k + 4);
	} // method removeQueen
	
	public String toString() {
		return arrangement();
	}

} // class Board2