package liste;

public class SList<T> {
	
	private final boolean empty; 
	private final T first;
	private final SList<T> rest;
	
	public SList() {
		empty = true;
		first = null;
		rest = null;
	}	// constructor IntSList empty
	
	public SList(T e, SList<T> il) {
		empty = false;
		first = e;
		rest = il;
	}	// constructor IntSList not empty
	
	public boolean isNull() {
		return empty;
	}	// method isNull
	
	public T car() {
		return first;
	}	// method car
	
	public SList<T> cdr() {
		return rest;
	}	// method cdr
	
	public SList<T> cons(T e) {
		return new SList<T>(e, this);
	}	// method cons
	
	public int length() {
		if (isNull()) {
			return 0;
		} else {
			return (1 + cdr().length());
		}
	}	// method length
	
	public T listRef(int i) {
		if (i == 0) {
			return car();
		} else {
			return cdr().listRef(i-1);
		}
	}	// method listRef
	
	public boolean equals(SList<T> il) {
		if (isNull()) {
			return il.isNull();
		} else if (il.isNull()) {
			return false;	// so che la prima lista non è vuota
		} else if (car() == il.car()) {
			return cdr().equals(il.cdr());	// effettuo i controlli al resto delle liste
		} else {
			return false;
		}
	}	// method equals
	
	public SList<T> append(SList<T> il) {
		if (isNull()) {
			return il;
		} else {
			return cdr().append(il).cons(car());
		}
	}	// method append
	
	public SList<T> reverse() {
		return reverseRec(new SList<T>());
	}	// method reverse
	
	// uso private xk è un metodo aggiuntivo per la funzionalità del reverse, non fa parte del protocollo
	private SList<T> reverseRec(SList<T> re) {
		if (isNull()) {
			return re;
		} else {
			return cdr().reverseRec(re.cons(car()));
		}
	}	// method reverseRec
	
	public String toString() {
		if (empty) {
			return "()";
		} else if (rest.isNull()) {
			return "(" + first + ")";
		} else {
			String rep = "(" + first;
			SList<T> r = rest;
			while (!r.isNull()) {
				rep = rep + ", " + r.car();
		        r = r.cdr();
			}
			return (rep + ")");
		}
	}	// method toString

}	// class IntSList