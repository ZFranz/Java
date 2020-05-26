package correttezzaFormale;

public class Correctness {

	// ritorna un quadrato di un numero n
	public static int sqr(int n) {	/** Pre-condizione: n >= 0  */
		int x = 0;
		int y = 0;
		int z = 1;
		
		while (x < n) { 			/** Invariante: 0 <= x <= n,  y = x^2,  z = 2x+1  */
									/** terminazione: n-x  */
			x++;
			y += z;
			z += 2;
		}
		return y; 					/** Post-condizione: y = n^2  */
	} // method sqr
	
	/**
	 * Notazione: Inv(x,y,z)
	 * 
	 * Inv(0,0,1) : 0 <= 0 <= n,  0 = 0^2,  1 = 2*0+1
	 * 					 0 <= n  <-- Pre
	 * 
	 * Conservazione
	 * Assumo:		Inv(x,y,z) & (x < n)
	 * Dimostro:	Inv(x+1,y+z,z+2)
	 * 
	 * Inv(x+1,y+z,z+2) : 0 <= x+1 <= n,  y+z = (x+1)^2,  z+2 = 2(x+1)+1
	 * 					  0 <= x+1  <--  0 <= x
	 * 						   x+1 <= n  <--  x < n
	 * 									  y+z = (x+1)^2 = x^2 + 2x+1  <--  y = x^2,  < = 2x+1
	 * 													  z+2 = 2(x+1)+1 = 2x+1 + 2  <--  z = 2x+1
	 * Risultato finale
	 * Assumo:		Inv(x,y,z) & (x >= n)
	 * Dimostro:	y = n^2
	 * 
	 *   x <= n,  x >= n  -->  x = n
	 *   x = n,  y = x^2  -->  y = n^2
	 *   
	 * Terminazione
	 *   
	 *   term(x,y,z) = n-x  <--  x <= n
	 *   
	 *   term(x+1,y+z,z+2) = n - (x+1) = n-x - 1 < n-x = term(x,y,z)  <--  Inv(x,y,z)
	 */

	
	// calcolo del mcm
	public static int lcm(int m, int n) {	/** Pre: m, n > 0 */
		int x = m;
		int y = n;

		while (x != y) {					/** Inv:  0 < x, y <= mcm(m,n),  x mod m = 0,  y mod n = 0  */
											/** term: 2*mcm(m,n)-x-y  */
			if (x < y) {
				x += m;
			} else { // y < x
				y += n;
			}
		}
		return x; // y = x					/** Post: x = mcm(m,n)  */
	} // method lcm
	
	/**
	 * Notazione: Inv(x,y)
	 * 
	 * Inv(m,n) : 0 < m, n = mcm(m,n),  m mod m = 0,  n mod n = 0
	 * 			  Pre
	 * 
	 * Conservazione
	 * Assumo (a):	Inv(x,y) & (x < y)
	 * Dimostro:	Inv(x+m,y)
	 * 
	 * (a) Inv(x+m,y) :  0 < x+m, y <= mcm(m,n),  (x+m) mod m = 0, y mod n = 0
	 * 
	 *   x < y <= mcm(m,n)  -->  x+m <= mcm(m,n)
	 * 
	 * 
	 * Assumo (b):	Inv(x,y) & (x > y)
	 * Dimostro:	Inv(x,y+n)
	 * 
	 * (b) Inv(x,y+n) :  0 < y+n, x <= mcm(m,n),  (y+n) mod n = 0, x mod m = 0
	 * 
	 *   y < x <= mcm(m,n)  -->  y+n <= mcm(m,n)
	 *   
	 *   
	 * Risultato finale
	 * Assumo:		Inv(x,y) & (x = y)
	 * Dimostro:	x = mcm(m,n)
	 * 
	 *   0 < m, n = mcm(m,n),  m mod m = 0,  n mod n = 0
	 *   x mod m = 0,  x mod n = 0  -->  x >= mcm(m,n)
	 *   x = mcm(m,n) 
	 *   
	 * Terminazione
	 *   
	 *   term(x,y) = 2*mcm(m,n)-x-y >= 0  <--  x, y <= mcm(m,n)
	 *   
	 *   term(x',y') = 2*mcm(m,n)-x'-y' <= 2*mcm(m,n)-x-y-min(m,n) < 2*mcm(m,n)-x-y  <--  m, n > 0
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcm(2,5));
	} // method main

} // class Correctness
