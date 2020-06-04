package correttezzaFormale;

import java.util.Vector;

public class ProximityStructure {

	private Vector<Double> collezione;

	public ProximityStructure() { // costruisce una collezione vuota di misure
		collezione = new Vector<Double>();
	} // constructor ProximityStructure

	public int size() { // restituisce il numero di misure contenute nella collezione
		return collezione.size();
	} // method size

	public void add(double x) { // aggiunge la misura x alla collezione s
		collezione.add(x);
	} // method add

	public double removeClosestTo(double x) { // la struttura non è vuota
		// rimuove da s e restituisce la misura più prossima a x
		// (la cui distanza da x è più piccola) in s

		double y = collezione.get(0); // elemento più vicino a x
		int n = collezione.size();
		int k = 0; // posizione del candidato, aggiornato ogni volta che si avvicina a x

		for (int i = 1; i < n; i++) {
			double z = collezione.get(i);
			if (Math.abs(z - x) < Math.abs(y - x)) {
				y = z;
				k = i;
			}
		}
		collezione.removeElementAt(k);

		return y;
	} // method removeClosestTo

	public static void main(String[] args) {
		ProximityStructure ps = new ProximityStructure();
		ps.add(Math.sqrt(5) - 1 / 2);
		ps.add(2.5);
		System.out.println(ps.removeClosestTo(1.8));

	} // method main

} // class ProximityStructure
