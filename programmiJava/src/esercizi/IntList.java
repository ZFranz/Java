package esercizi;

import liste.IntSList;

public class IntList {

	private final int n;
	private final boolean empty;
	private final IntList u;

	public IntList() { // null
		this.n = 0;
		this.empty = true;
		this.u = null;
	}

	public IntList(int n, IntList u) { // cons
		this.n = n;
		this.empty = false;
		this.u = u;
	}

	public boolean isNull() { // null?
		return empty;
	}

	public int car() { // car
		return this.n;
	}

	public IntList cdr() { // cdr
		return this.u;
	}

	public int length() { // length
		if (isNull()) {
			return 0;
		} else {
			return (1 + cdr().length());
		}
	}
	
	public IntList cons(int n) { // cons
		return (new IntList(n, this));
	}

	public IntList append(IntList v) { // append

		if (isNull()) {
			return v;
		} else {
			return new IntList(car(), cdr().append(v));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
