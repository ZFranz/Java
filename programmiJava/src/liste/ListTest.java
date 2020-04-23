package liste;

/**
 * Test di oggetti di tipo InsSList
 * 
 * @author zhouf
 *
 */
public class ListTest {

	/**
	 * @param args
	 */

	/*
	 * return -> si tratta di una funzione che restituisce un valore
	 * System.out.print -> 	visualizza in un formato testuale il contenuto che voglio
	 * 						leggere non restituisce valori, ma li stampa
	 */

	public static IntSList range(int m, int n) {
		if (m > n) {
			return IntSList.NULL_INTLIST;
		} else {
			return range(m + 1, n).cons(m);
		}
	} // method range

	public static IntSList range1(int m, int n) {
		if (m > n) {
			return IntSList.NULL_INTLIST;
		} else {
			IntSList il = new IntSList();
			for (int i = n; i >= m; i--) {
				il = il.cons(i);
			}
			return il;
		}
	} // method range1

	public static int test() {
		IntSList il = new IntSList();
		il = new IntSList(5, il);
		il = il.cons(4);

		return il.cdr().car();
	} // method test

	public static void test1(int m, int n) {
		System.out.println(range(m, n));
	} // method test1

	public static String test2() {
		StringSList sl = new StringSList();
		sl = new StringSList("ciao", sl);
		sl = sl.cons("mondo");
		sl = sl.cons("nuovo");
		StringSList sl1 = new StringSList();
		sl1 = new StringSList("prova", sl1);
		sl1 = sl1.append(sl);
		// sl1 = sl1.reverse();

		return sl1.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * IntSList il = range(1, 10);
		 * IntSList rl = il.reverse();
		 * IntSList al = il.append(rl.cdr());
		 * 
		 * System.out.println(il);
		 * System.out.println(rl);
		 * System.out.println(al);
		 * 
		 * for(int i = 0; i < al.length(); i++) { 
		 * 	System.out.print(" " + al.listRef(i));
		 * }
		 * System.out.println();
		 * 
		 * System.out.println(IntSList.NULL_INTLIST.equals(new IntSList()));
		 * System.out.println(il.equals(al));
		 * System.out.println(il.equals(rl));
		 * System.out.println(il.equals(rl.reverse()));
		 * 
		 * System.out.println(IntSList.NULL_INTLIST.equals(new IntSList()));
		 * System.out.println(IntSList.NULL_INTLIST == new IntSList());
		 * System.out.println(il.equals(rl.reverse()));
		 * System.out.println(il == rl.reverse());
		 * 
		 * IntSList xl = il;
		 * 
		 * System.out.println(IntSList.NULL_INTLIST == IntSList.NULL_INTLIST);
		 * System.out.println(il == il);
		 * System.out.println(xl == il);
		 */

		System.out.println(test2());
	} // method main

} // class ListTest
