package tavolaRotonda;

import liste.IntSList;

public class TavolaRotondav3 {

	private final IntSList cavalieri;
	private final IntSList seguito;
	private final int num;

	public TavolaRotondav3(int n) { // n > 0
		cavalieri = range(1, n);
		seguito = IntSList.NULL_INTLIST;
		num = n;
	} // constructor TavolaRotondav3

	private TavolaRotondav3(IntSList cav, IntSList seg, int n) {
		cavalieri = cav;
		seguito = seg;
		num = n;
	} // constructor TavolaRotondav3

	public int numeroDiCavalieri() {
		return num;
	} // method numeroDiCavalieri

	public int cavConLaBrocca() {
		return cavalieri.car();
	} // method cavConLaBrocca

	public TavolaRotondav3 dopoUscitaCav() {
		IntSList u = cavalieri.cdr();
		IntSList v = seguito.cons(cavalieri.car());

		if (u.isNull()) {
			return new TavolaRotondav3(v.reverse().cdr(), IntSList.NULL_INTLIST, num - 1);
		} else if (u.cdr().isNull()) {
			return new TavolaRotondav3(v.reverse(), IntSList.NULL_INTLIST, num - 1);
		} else {
			return new TavolaRotondav3(u.cdr(), v, num - 1);
		}
	} // method dopoUscitaCav

	private static IntSList range(int m, int n) {
		if (m > n) {
			return IntSList.NULL_INTLIST;
		} else {
			return range(m + 1, n).cons(m);
		}
	} // method range

} // class TavolaRotondav3
