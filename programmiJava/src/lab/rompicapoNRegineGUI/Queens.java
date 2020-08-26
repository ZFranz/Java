package lab.rompicapoNRegineGUI;

import liste.SList;
import queens.ChessboardView;

public class Queens {

	public static void viewBoard(SList<Board> lista) {
        Board s;
        ChessboardView gui = new ChessboardView(6);
        while (!lista.isNull()) {
            s = lista.car();
            gui.setQueens(s.arrangement());
            lista = lista.cdr();
        }
    }

    public static SList<Board> listOfSolutions(int n) {
        return listOfCompletations(new Board(n));
    }

    public static SList<Board> listOfCompletations(Board t) {
        int n = t.getSize();
        int q = t.getQueens();

        if (q == n) {
            return new SList<Board>().cons(t);

        } else { // q < n

            int i = q + 1;
            SList<Board> sl = new SList<>();
            for (int j = 1; j <= n; j++) {
                if (!t.underAttack(i, j)) {
                    sl = sl.append(listOfCompletations(t.addQueen(i, j)));

                }
            }

            return sl;
        }
    }

    /*
     * Numero di soluzioni:
     *
     * Il numero di modi diversi in cui si possono disporre n regine
     * in una scacchiera n x n è dato dal numero di modi diversi in
     * cui si può completare la disposizione delle regine:
     *
     * --> numberOfCompletions(new Board(n))
     *
     * a partire da una scacchiera n x n inizialmente vuota
     */
    public static int numeroDiSoluzioni(int n) {
        return numeroDiCompletamenti(new Board(n));
    }

    /*
     * Il numero di modi in cui si può completare la disposizione
     * a partire da una scacchiera b parzialmente configurata
     *
     * --> numberOfCompletions(b) : int
     *
     * dove k regine (0 <= k < n) sono collocate nelle prime k righe
     * di b, si può determinare a partire dalle configurazioni
     * che si ottengono aggiungendo una regina nella riga k + 1 in tutti
     * i modi possibili (nelle posizioni che non sono già minacciate)
     *
     * for ( int j = 1; j <= n; j = j+1 ) {
     *   if (!b.underAttack(i,j)) {
     *          ... b.addQueen(i,j) ...
     *      }
     * }
     *
     * calcolando ricorsivamente per ciascuna di queste il numero
     * di modi in cui si può completare la disposizione
     *
     * numberOfCompletions(b.addQueen(i,j))
     *
     * e sommando i valori che ne risultano
     * count = count + numberOfCompletions(...)
     *
     * Se invece la scacchiera rappresenta una soluzione (q == n)
     * c'è un solo modo (banale) di completare la disposizione:
     * lasciare le cose come stanno!
     */
    private static int numeroDiCompletamenti(Board b) {

        int n = b.getSize();
        int q = b.getQueens();

        if (q == n) {

            return 1;

        } else { // q < n

            int i = q + 1;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    count += numeroDiCompletamenti(b.addQueen(i, j));
                }
            }

            return count;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SList<Board> list = Queens.listOfSolutions(6);
        viewBoard(list);

        System.out.println(Queens.numeroDiSoluzioni(1)); // 1
        System.out.println(Queens.numeroDiSoluzioni(2)); // 0
        System.out.println(Queens.numeroDiSoluzioni(3)); // 0
        System.out.println(Queens.numeroDiSoluzioni(4)); // 2
        System.out.println(Queens.numeroDiSoluzioni(5)); // 10
        System.out.println(Queens.numeroDiSoluzioni(6)); // 4
        System.out.println(Queens.numeroDiSoluzioni(7)); // 40
        System.out.println(Queens.numeroDiSoluzioni(8)); // 92
        System.out.println(Queens.numeroDiSoluzioni(9)); // 352
        System.out.println(Queens.numeroDiSoluzioni(10)); // 724
	}

}
