package tavolaRotonda;

public class TavolaRotondav2 {

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
	
	private final int[] cavalieri;
	
	public TavolaRotondav2(int n) {  // n > 0
		cavalieri = new int[n];
		
		for(int k = 1; k <= n; k++) {
			cavalieri[k-1] = k;
		}
	}	//constructor TavolaRotonda
	
	private TavolaRotondav2(int[] cav) {
		cavalieri = cav;
	}	//constructor TavolaRotonda
	
	public int numeroDiCavalieri() {
		return cavalieri.length;
	}	// method numeroDiCavalieri
	
	public int cavConLaBrocca() {
		return cavalieri[0];
	}	// method cavConLaBrocca
	
	public TavolaRotondav2 dopoUscitaCav() {
		int n = cavalieri.length - 1;
		int[] cav = new int[n];
		
		for(int i = 0; i < n - 1; i++) {
			cav[i] = cavalieri[i + 2];
		}
		cav[n - 1] = cavalieri[0];
		
		return new TavolaRotondav2(cav);
	}	// method dopoUscitaCav

}	// class TavolaRotonda
