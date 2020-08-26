package liste;

public class StringSList {

	public static final StringSList NULL_STRINGLIST = new StringSList(); // lista vuota definita come costante

	private final boolean empty;
	private final String first;
	private final StringSList rest;

	public StringSList() {
		empty = true;
		first = ""; // irrilevante
		rest = null;
	} // constructor StringSList empty

	public StringSList(String e, StringSList sl) {
		empty = false;
		first = e;
		rest = sl;
	} // constructor IntSList not empty

	public boolean isNull() {
		return empty;
	} // method isNull

	public String car() {
		return first;
	} // method car

	public StringSList cdr() {
		return rest;
	} // method cdr

	public StringSList cons(String e) {
		return (new StringSList(e, this));
	} // method cons

	public int length() {
		if (isNull()) {
			return 0;
		} else {
			return (1 + cdr().length());
		}
	} // method length

	public String listRef(int i) {
		if (i == 0) {
			return car();
		} else {
			return cdr().listRef(i - 1);
		}
	} // method listRef

	public boolean equals(StringSList sl) {
		if (isNull()) {
			return sl.isNull();
		} else if (sl.isNull()) {
			return false; // so che la prima lista non � vuota
		} else if (car() == sl.car()) {
			return cdr().equals(sl.cdr()); // effettuo i controlli al resto delle liste
		} else {
			return false;
		}
	} // method equals

	public StringSList append(StringSList sl) {
		if (isNull()) {
			return sl;
		} else {
			return cdr().append(sl).cons(car());
		}
	} // method append

	public StringSList reverse() {
		return reverseRec(NULL_STRINGLIST);
	} // method reverse

	// uso private xk � un metodo aggiuntivo per la funzionalit� del reverse, non fa
	// parte del protocollo
	private StringSList reverseRec(StringSList rl) {
		if (isNull()) {
			return rl;
		} else {
			return cdr().reverseRec(rl.cons(car()));
		}
	} // method reverseRec

	public String toString() {
		if (empty) {
			return "()";
		} else if (rest.isNull()) {
			return "(\"" + first + "\")";
		} else {
			String rep = "(\"" + first;
			StringSList r = rest;
			while (!r.isNull()) {
				rep = rep + "\", \"" + r.car();
				r = r.cdr();
			}
			return (rep + "\")");
		}
	} // method toString

} // class StringSList
