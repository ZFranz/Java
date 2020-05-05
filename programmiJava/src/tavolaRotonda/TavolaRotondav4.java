package tavolaRotonda;

/**
 * TavolaRotonda t = new TavolaRotonda()
 * 
 * t.numeroDiCavalieri() : int 
 * t.cavConLaBrocca() : int
 * 
 * t.dopoUscitaCav();
 * 
 * @author zhouf
 *
 */
public class TavolaRotondav4 {

	// ----- Rappresentazione interna del modello: private!
	private int[] cavalieri; // array dei cavalieri (numerati)
	private int num; // numero dei cavalieri a tavola
	private int brocca; // pos. cavalierie con la brocca

	// ----- Costruttore pubblico
	public TavolaRotondav4(int n) { // creazione di una tavola con n cavalieri
		cavalieri = new int[2 * n - 1];

		for (int k = 1; k <= n; k++) {
			cavalieri[k - 1] = k;
		}
		num = n;
		brocca = 0;
	} // constructor TavolaRotonda

	// ----- Metodi del protocollo: acquisizione di informazioni sulla
	// configurazione
	public int numeroDiCavalieri() { // numero di cavalieri a tavola
		return num;
	} // method numeroDiCavalieri

	public int cavConLaBrocca() { // cavalieri con la brocca
		return cavalieri[brocca];
	} // method cavConLaBrocca

	// ----- Metodi del protocollo: configurazione successiva a una mossa
	public void dopoUscitaCav() {
		cavalieri[brocca + num] = cavalieri[brocca];
		brocca = brocca + 2; // il secondo cavaliere a sinistra(orario) riceve la brocca
		num = num - 1;
	} // method dopoUscitaCav

} // class TavolaRotondav4
