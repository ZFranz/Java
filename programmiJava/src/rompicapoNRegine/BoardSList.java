package rompicapoNRegine;

import java.util.Iterator;

import rompicapoNRegine.Board;

/**
 * Definizione di una classe per realizzare una lista di Board.
 *
 * Le liste create sono "immutabili".
 *
 * Class overview:
 * BoardSList() : Default Constructor
 * BoardSList(Board b, BoardSList bsl) : Constructor
 * isEmpty() : boolean
 * car() : Board
 * cdr() : BoardSList
 * cons(Board s) : BoardSList
 * length() : int
 * listRef(int index) : Board
 * equals(BoardSList sList) : boolean
 * append(BoardSList list) : BoardSList
 * reverse() : BoardSList
 * toString() : String
 * display(BoardSList sList) : void
 * iterator() : Iterator<Board>
 *
 */

public class BoardSList implements Iterable<Board> {
	
	// costante globale di classe (condivisa)
    public static final BoardSList NULL_BOARDLIST = new BoardSList();
    // Rappresentazione interna di una lista di Board
    // variabili di istanza private immutabili
    private final boolean empty;
    private final Board firstElement;      // Primo elemento della lista
    private final BoardSList restElements; // Contiene il resto della lista senza il primo elemento
    
	/**
	 * Costruttore di una lista di Board vuota
	 */
	public BoardSList() {
		this.empty = true;
		this.firstElement = null;
		this.restElements = null;
	}

	/**
	 * Costruttore di una lista non vuota
	 *
	 * @param b   the first element of the BoardSList
	 * @param bsl the rest elements of the BoardSList
	 */
	public BoardSList(Board b, BoardSList bsl) {
		this.empty = false;
		this.firstElement = b;
		this.restElements = bsl;
	}
    
	/**
     * Verifica se la lista è vuota
     *
     * @return true if BoardSList is empty, false otherwise
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Ritorna il primo elemento della lista
     *
     * @return the first element of BoardSList
     */
    public Board car() {
        return firstElement;
    }

    /**
     * Ritorna la lista tranne il primo elemento
     *
     * @return the BoardSList without the first element
     */
    public BoardSList cdr() {
        return restElements;
    }

    /**
     * Costruisce una lista a partire dall'elemento s in prima posizione
     *
     * @param s a Board element
     * @return a BoardSList starting from s in the first position
     */
    public BoardSList cons(Board s) {
        return new BoardSList(s, this);
    }

    /**
     * Calcola la lunghezza di BoardSList
     *
     * @return the length of the List
     */
    public int length() {
        if (this.isEmpty()) {
            return 0;

        } else {
            return this.cdr().length() + 1;
        }
    }
    
    /**
     * Restituisce l'i-esimo elemento della lista
     *
     * @param index the index of the element within the list
     * @return the Board searched if the index is between 0 and the length of the list
     */
    public Board listRef(int index) {
        if (index == 0) {
            return car();

        } else {
            return cdr().listRef(index - 1);
        }
    }

    /**
     * Confronta se due liste sono uguali
     *
     * @param sList the list to compare
     * @return true if this and sList are equals, false otherwise
     */
    public boolean equals(BoardSList sList) {
        if (this.isEmpty()) {
            return sList.isEmpty();

        } else if (sList.isEmpty()) {
            return false;

        } else if (car().equals(sList.car())) {
            return this.cdr().equals(sList.cdr());

        } else {
            return false;
        }
    }

    /**
     * Aggiunge in coda una nuova lista
     *
     * @param list the list to add at the end of this
     * @return the complete BoardSList with list
     */
    public BoardSList append(BoardSList list) {
        if (this.isEmpty()) {
            return list;

        } else {
            return this.cdr().append(list).cons(car());
        }
    }

    /**
     * Restituisce la lista con gli elementi invertiti
     *
     * @return the list with inverted elements
     */
    public BoardSList reverse() {
        return reverseRec(NULL_BOARDLIST);
    }

    /**
     * Metodo di supporto privato che inverte gli elementi della lista rl
     *
     * @param rl the list to reverse
     * @return the list with inverted elements
     */
    private BoardSList reverseRec(BoardSList rl) {
        if (this.isEmpty()) {
            return rl;

        } else {
            return cdr().reverseRec(rl.cons(car()));
        }
    }

    /**
     * Visualizza la lista di Board
     *
     * @return the BoardSList in string format
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "(---)";

        } else if (restElements.isEmpty()) {
            return "(" + this.firstElement + ")";

        } else {
            String elements = "(" + this.firstElement;
            BoardSList restEl = this.restElements;

            while (!restEl.isEmpty()) {
                elements = elements + ", " + restEl.car();
                restEl   = restEl.cdr();
            }

            return elements + ")";
        }
    }

    /**
     * Visualizza la lista di Board
     *
     * @param sList la lista di Board da visualizzare
     */
    public void display(BoardSList sList) {
        String s = "(";
        String t = ")";

        System.out.print(s);

        for (Board el : sList) {
            if (el != listRef(length() - 1)) {
                System.out.print(el + ", ");

            } else {
                System.out.print(el);
            }
        }

        System.out.print(t);
    }

    /**
     * Iteratore: Permette di iterare sugli elementi della lista.
     *
     * @return the BoardSList with the iterator() method
     */
    @Override
    public Iterator<Board> iterator() {
        BoardSList c = this;

        return new Iterator<Board>() {
            private BoardSList current = c;

            @Override
            public boolean hasNext() {
                return current != null && !current.isEmpty();
            }

            @Override
            public Board next() {
                Board i = current.firstElement;
                current = current.restElements;
                return i;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
