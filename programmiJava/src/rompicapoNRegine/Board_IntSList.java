package rompicapoNRegine;

import liste.IntSList;

public class Board_IntSList {

	private static final IntSList NULL_INDEXLIST = IntSList.NULL_INTLIST;
	private static final String ROWS = " 123456789ABCDEF";
	private static final String COLS = " abcdefghijklmno";

	private final int size;
	private final int queens;
	private final IntSList rws;
	private final IntSList cls;
	private final IntSList dg1;
	private final IntSList dg2;
	private final String config; // configurazione, disposizione delle regine

	public Board_IntSList(int n) {
		size = n;
		queens = 0;
		rws = NULL_INDEXLIST;
		cls = NULL_INDEXLIST;
		dg1 = NULL_INDEXLIST;
		dg2 = NULL_INDEXLIST;
		config = "";
	} // constructor Board_IntSList vuoto

	private Board_IntSList(int n, int q, IntSList rs, IntSList cs, IntSList dg1s, IntSList dg2s, String c) {
		size = n;
		queens = q;
		rws = rs;
		cls = cs;
		dg1 = dg1s;
		dg2 = dg2s;
		config = c;
	} // constructor Board_IntSList non vuoto

	public int size() { // dimensione della scacchiera
		return size;
	} // method size

	public int queensOn() { // quante regine ci sono
		return queens;
	} // method queensOn

	public boolean underAttack(int i, int j) { // controllo se una regina viene attaccata da un'altra regina
		return attack.test(i, j); // (attack i j)
	} // method underAttack

	public String arrangement() {
		return config;
	} // method arrangement

	public Board_IntSList addQueen(int i, int j) {
		return new Board_IntSList(size, queens + 1, rws.cons(i), cls.cons(j), dg1.cons(i - j), dg2.cons(i + j),
				config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ", i, j);
	} // method addQueen

	public String toString() {
		return "[" + config + "]";
	}

} // class Board_IntSList