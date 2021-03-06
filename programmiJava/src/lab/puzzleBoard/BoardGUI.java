package lab.puzzleBoard;

import liste.IntSList;
import puzzleboard.PuzzleBoard;

/**
 * Problema 13 - 12/05/2020 Rompicapo del 15
 * 
 * @author zhouf
 *
 */
public class BoardGUI {
	private final int size; // dimensione della tavoletta generalizzata al caso n x x
	private final int cells; // numero di tasselli nella tavoletta n x n
	private int[][] board; // matrice n*n
	private int z_row; // coordinata della riga dello 0
	private int z_col; // coordinata della colonna dello 0
	private static IntSList list = new IntSList(); // lista con i numeri generati random senza ripetizioni
	private static int[] orderedList;
	private static int r = 0;
	private static int c = 0;
	private static PuzzleBoard gui;
	private static int k;
	private static int moves = 0;

	/**
	 * Costruttore della tavola di dimensioni n*n
	 * 
	 * @param n - dimensione della tavola
	 */
	public BoardGUI(int n) {
		size = n;
		cells = n * n;
		board = new int[n][n];
		orderedList = new int[cells];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				generate(cells);
				// t = (t + 1) % cells;
				// board[i][j] = t;
				if (list.car() != 0) {
					gui.setNumber(i + 1, j + 1, list.car());
				}
				if (list.car() == 0) {
					z_row = i;
					z_col = j;
				}
				board[i][j] = list.car();
			}
		}
	} // constructor Board

	public int getSize() {
		return size;
	} // method getSize

	public int getCells() {
		return cells;
	} // method getCells

	public boolean isOrdered() {
		if (board[size - 1][size - 1] != 0) {
			return false;
		} else {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (board[i][j] != orderedList[j + (size * i)]) {
						return false;
					}
				}
			}
			return true;
		}
	} // method isOrdered

	public boolean isMovable(int n) {
		if (n % size == 0) {
			r = n / size - 1;
			c = (n % size) + (size - 1);
		} else {
			r = n / size;
			c = n % size - 1;
		}

		if ((r != 0) && (r != (size - 1)) && (c != 0) && (c != (size - 1))) {
			if ((board[r][c + 1] == 0) || (board[r][c - 1] == 0) || (board[r + 1][c] == 0) || (board[r - 1][c] == 0)) {
				return true;
			}
		} else if ((r == 0) && (c == 0)) {
			if ((board[r][c + 1] == 0) || (board[r + 1][c] == 0)) {
				return true;
			}
		} else if ((r == (size - 1)) && (c == (size - 1))) {
			if ((board[r][c - 1] == 0) || (board[r - 1][c] == 0)) {
				return true;
			}
		} else if ((r == 0) && (c == (size - 1))) {
			if ((board[r + 1][c] == 0) || (board[r][c - 1] == 0)) {
				return true;
			}
		} else if ((r == (size - 1)) && (c == 0)) {
			if ((board[r][c + 1] == 0) || (board[r - 1][c] == 0)) {
				return true;
			}
		} else if ((r == 0) && (c != 0)) {
			if ((board[r][c + 1] == 0) || (board[r][c - 1] == 0) || (board[r + 1][c] == 0)) {
				return true;
			}
		} else if ((r == (size - 1)) && (c != 0)) {
			if ((board[r][c + 1] == 0) || (board[r][c - 1] == 0) || (board[r - 1][c] == 0)) {
				return true;
			}
		} else if ((r != 0) && (c == 0)) {
			if ((board[r][c + 1] == 0) || (board[r - 1][c] == 0) || (board[r + 1][c] == 0)) {
				return true;
			}
		} else if ((r != 0) && (c == (size - 1))) {
			if ((board[r][c - 1] == 0) || (board[r - 1][c] == 0) || (board[r + 1][c] == 0)) {
				return true;
			}
		}

		return false;
	} // method isMovable

	public String toString() {
		String s = "";

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] < 10) {
					s = s + "  " + board[i][j] + " ";
				} else if (board[i][j] < 100) {
					s = s + " " + board[i][j] + " ";
				} else {
					s = s + board[i][j] + " ";
				}

			}
			s = s + "\n";
		}

		return s;
	} // method toString

	public static void generate(int n) {
		int rand = (int) (Math.random() * n);

		if (list.isNull()) {
			list = list.cons(rand);
		} else if (!list.belong(rand)) {
			list = list.cons(rand);
		} else {
			generate(n);
		}

	} // method generate

	public static void insert(int i, IntSList l) {
		if (!l.isNull()) {
			orderedList[i] = l.car();
			if (!l.cdr().isNull()) {
				insert(i + 1, l.cdr());
			}
		}
	} // method insert

	public void slide(int n) {
		if (isMovable(n)) {
			gui.setNumber(z_row + 1, z_col + 1, k);
			board[z_row][z_col] = board[r][c];
			System.out.println("row: " + z_row + "\ncol: " + z_col);
			System.out.println(board[z_row][z_col]);
			gui.clear(r + 1, c + 1);
			board[r][c] = 0;
			z_col = c;
			z_row = r;
		}
	} // method slide

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pos = 0;
		gui = new PuzzleBoard(4);
		BoardGUI b = new BoardGUI(4);
		System.out.println(b);

		// ----- ordino la lista e la inserisco in un vettore
		list = list.sortedList(list);
		list = list.remove(0, list);
		list = list.append(new IntSList().cons(0));
		insert(0, list);

		while (true) {
			k = gui.get();
			for (int i = 0; i < b.size; i++) {
				for (int j = 0; j < b.size; j++) {
					if (b.board[i][j] == k) {
						pos = (1 + j + (i * b.size));
						break;
					}
				}
			}
			b.slide(pos);
			gui.display();
			moves++;
			if (b.isOrdered()) {
				System.out.println("Hai vinto!");
				System.out.println("Per risolvere la tabella " + b.size + "X" + b.size + " hai impiegato " + moves + " mosse.");
				break;
			}
			// System.out.println(k);
		}

	}

} // class Board
