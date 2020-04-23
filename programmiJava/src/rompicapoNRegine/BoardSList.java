package rompicapoNRegine;

public class BoardSList {

	public static final BoardSList NULL_BOARDLIST = new BoardSList(); // lista vuota definita come costante

	private final boolean empty;
	private final Board first;
	private final BoardSList rest;

	public BoardSList() {
		empty = true;
		first = null; // irrilevante
		rest = null;
	} // constructor BoardSList empty

	private BoardSList(Board f, BoardSList r) {
		empty = false;
		first = f;
		rest = r;
	} // constructor BoardSList not empty

	public boolean isNull() {
		return empty;
	} // method isNull

	public Board car() {
		return first;
	} // method car

	public BoardSList cdr() {
		return rest;
	} // method cdr

	public BoardSList cons(Board b) {
		return (new BoardSList(b, this));
	} // method cons

	public int length() {
		if (isNull()) {
			return 0;
		} else {
			return (1 + cdr().length());
		}
	} // method length

	public Board listRef(int i) {
		if (i == 0) {
			return car();
		} else {
			return cdr().listRef(i - 1);
		}
	} // method listRef

	public boolean equals(BoardSList cl) {
		if (isNull()) {
			return cl.isNull();
		} else if (cl.isNull()) {
			return false; // so che la prima lista non è vuota
		} else if (car() == cl.car()) {
			return cdr().equals(cl.cdr()); // effettuo i controlli al resto delle liste
		} else {
			return false;
		}
	} // method equals

	public BoardSList append(BoardSList ql) {
		if (isNull()) {
			return ql;
		} else {
			return cdr().append(ql).cons(car());
		}
	} // method append

	public BoardSList reverse() {
		return reverseRec(NULL_BOARDLIST);
	} // method reverse

	// uso private xk è un metodo aggiuntivo per la funzionalità del reverse, non fa
	// parte del protocollo
	private BoardSList reverseRec(BoardSList rl) {
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
			return "(" + first.arrangement() + ")";
		} else {
			String rep = "(" + first.arrangement();
			BoardSList r = rest;
			while (!r.isNull()) {
				rep = rep + ")\n(" + r.car();
				r = r.cdr();
			}
			return (rep + ")");
		}
	} // method toString

}