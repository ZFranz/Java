package tavolaRotonda;

import liste.IntSList;

public class TavolaRotonda {
	
	/**
	 * 
	 * Costruttori per creare "nuove" situazioni
	 * 
	 * TavolaRotonda tr = new TavolaRotonda(n) : n>=0
	 * 
	 * Metodi per cquisire informazioni sulla situazione modellata
	 * 
	 * TavolaRotonda tr;
	 * 
	 * tr.numeroDiCavalieri() : int
	 * tr.cavConLaBrocca      : int [etichetta, posizione]
	 * ...
	 * 
	 * 
	 * Metodi per generare una nuova situazione a partire da una situazione data:
	 * 
	 * tr.dopoUscitaCav()     : TavolaRotonda
	 * 
	 * @param args
	 */

	private final IntSList cavalieri;

	public TavolaRotonda(int n) { // n > 0
		cavalieri = range(1, n);
	} // constructor TavolaRotonda

	private TavolaRotonda(IntSList cav) {
		cavalieri = cav;
	} // constructor TavolaRotonda

	public int numeroDiCavalieri() {
		return cavalieri.length();
	} // method numeroDiCavalieri

	public int cavConLaBrocca() {
		return cavalieri.car();
	} // method cavConLaBrocca

	public TavolaRotonda dopoUscitaCav() {
		IntSList listaDiUnElemento = IntSList.NULL_INTLIST.cons(cavalieri.car());
		IntSList listaCon2ElementiInMeno = cavalieri.cdr().cdr();

		IntSList nuovaLista = listaCon2ElementiInMeno.append(listaDiUnElemento);

		return new TavolaRotonda(nuovaLista);
	} // method dopoUscitaCav

	private static IntSList range(int m, int n) {
		if (m > n) {
			return IntSList.NULL_INTLIST;
		} else {
			return range(m + 1, n).cons(m);
		}
	} // method range

} // class TavolaRotonda
