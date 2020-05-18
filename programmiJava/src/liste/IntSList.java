package liste;

public class IntSList {
	
	/**
	 * IntSList il = new IntSList()		// null
	 * il.isNull() : boolean			// null?
	 * il.car()    : int				// car
	 * il.cdr()	   : IntSList			// cdr
	 * il.cons(n)  : IntSList			// cons
	 * 
	 * il.length()   : int				// length
	 * il.listRef(i) : int				// list-ref
	 * il.equals(cl) : boolean			// equal?
	 * il.append(ql) : IntSList			// append
	 * il.reverse()  : IntSList			// reverse
	 * 
	 */
	
	/* Esempi:
	 * 
	 * ( new IntSList() ).cons(5)	-->  (5)
	 * 
	 * oppure:
	 * 	IntSList il = new IntSList();
	 * il = il.cons(5);
	 * 
	 * il  -->  (5)
	 * il = il.isNull()  -->  false
	 * 
	 * il = il.cons(4)
	 * il  -->  (4 5)
	 * 
	 */
	
	/*
	 * final rende il valore della variabile immutabile, 
	 * riferisce al tempo di esecuzione e non al tempo di compilazione
	 * ovvero nel nostro caso quando verranno create nuove liste
	 */

	public static final IntSList NULL_INTLIST = new IntSList(); // lista vuota definita come costante

	private final boolean empty;
	private final int first;
	private final IntSList rest;

	public IntSList() {
		empty = true;
		first = 0; // irrilevante
		rest = null;
	} // constructor IntSList empty

	public IntSList(int f, IntSList r) {
		empty = false;
		first = f;
		rest = r;
	} // constructor IntSList not empty

	public boolean isNull() {
		return empty;
	} // method isNull

	public int car() {
		return first;
	} // method car

	public IntSList cdr() {
		return rest;
	} // method cdr

	public IntSList cons(int n) {
		return (new IntSList(n, this));
	} // method cons

	public boolean belong(int k) {
		if (this.isNull()) {
			return false;

		} else if (this.car() == k) {
			return true;

		} else {
			return cdr().belong(k);
		}
	} // method belong

	public int length() {
		if (isNull()) {
			return 0;
		} else {
			return (1 + cdr().length());
		}
	} // method length

	public int listRef(int i) {
		if (i == 0) {
			return car();
		} else {
			return cdr().listRef(i - 1);
		}
	} // method listRef

	public boolean equals(IntSList cl) {
		if (isNull()) {
			return cl.isNull();
		} else if (cl.isNull()) {
			return false; // so che la prima lista non � vuota
		} else if (car() == cl.car()) {
			return cdr().equals(cl.cdr()); // effettuo i controlli al resto delle liste
		} else {
			return false;
		}
	} // method equals

	public IntSList append(IntSList ql) {
		if (isNull()) {
			return ql;
		} else {
			return cdr().append(ql).cons(car());
		}
	} // method append

	public IntSList reverse() {
		return reverseRec(NULL_INTLIST);
	} // method reverse

	// uso private xk � un metodo aggiuntivo per la funzionalit� del reverse, non fa
	// parte del protocollo
	private IntSList reverseRec(IntSList rl) {
		if (isNull()) {
			return rl;
		} else {
			return cdr().reverseRec(rl.cons(car()));
		}
	} // method reverseRec
	
	public IntSList sortedIns(int n, IntSList il) {
		if (il.isNull()) {
			il = il.cons(n);
		} else if (il.belong(n)) {
			il = il.cdr().cons(il.car());
		} else if (n > il.car()) {
			il = sortedIns(n, il.cdr()).cons(il.car());
		} else {
			il = il.cons(n);
		}
		return il;
	} // method sortedIns
	
	public IntSList sortedList(IntSList il) {
		if (il.isNull()) {
			return il;
		} else {
			il = sortedIns(il.car(), sortedList(il.cdr()));
		}
		return il;
	} // method sortedList
	
	public IntSList remove(int n, IntSList il) {
		
		if (!il.isNull() && il.belong(n)) {
			if (n != il.car()) {
				
				il = remove(n, il.cdr()).cons(il.car());
			} else {
				il = new IntSList().append(il.cdr());
			}
		}
		return il;
	} // method remove

	public String toString() {
		if (empty) {
			return "()";
		} else if (rest.isNull()) {
			return "(" + first + ")";
		} else {
			String rep = "(" + first;
			IntSList r = rest;
			while (!r.isNull()) {
				rep = rep + ", " + r.car();
				r = r.cdr();
			}
			return (rep + ")");
		}
	} // method toString

} // class IntSList