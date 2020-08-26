package esame;

import liste.IntSList;

public class Towers {

	// Variabili di istanza
	private int disk;
	private IntSList rods[];
	private String move;

	// Costruttore
	public Towers(int n) {
		this.disk = n;
		this.rods = new IntSList[3];
		this.move = "";
		// inizializzo lo stato iniziale inserendo i dischi nella prima colonna
		for (int i = disk; i >= 1; i--) {
			rods[1].cons(i);
		}
	}

	// Metodi
	public void put(int disk, int rod) {
		for (int i = 0; i < rods.length; i++) {
			if (rods[rod].belong(disk)) {
				int k = 1;
				while(rods[rod].car() != disk) {
					k++;
				}
				System.out.println("Il disco " + disk + "si trova nella posizione " + k + " dell' asticella " + rod);
			} else {
				System.out.println("Il disco " + disk + "non si trova nell' asticella " + rod);
			}
		}
	} // method put

	public void move(int disk, int dst) {
		int pos = site(disk); // asticella di partenza del disco disk
		rods[pos].remove(disk, rods[pos]);
		rods[dst].append(new IntSList(disk, new IntSList())); // asticella di arrivo del disco disk
		// utilizzo append perché permette di isnerire gli elementi in coda, cons invece inserisce in testa
	} // method move

	public int height() {
		return this.disk;
	} // method height

	public int site(int disk) {
		int i = 0;
		while (rods[i].belong(disk)) {
			i++;
		}
		return i;
	} // method site

	public int transit(int disk, int dst) {
		return (3 - site(disk) - dst);
	} // method transit

	public String moves(int disk, int dst) {
		return move = move + (" " + dst + ":" + disk);
	} // method moves

} // class Towers
