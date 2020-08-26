package correttezzaFormale;

public class Essame_18_06_2015 {

	public static int[] extGcd(int m, int n) { 	// Pre: m, n > 0
		int x = m, u = 1, v = 0;
		int y = n, i = 0, j = 1;
		int q = x / y, r = x % y;
		while (r > 0) { 						// Inv: x, y > 0, x = qy + r, 0 ≤ r < y,
												// MCD(x,y) = MCD(m,n), x = um+vn, y = im+jn
			x = y;
			y = r; 								// Term: y
			int s = u - q * i;
			u = i;
			i = s;
			int t = v - q * j;
			v = j;
			j = t;
			q = x / y;
			r = x % y;
		}
		return new int[] { i, j }; 				// Post: MCD(m,n) = im + jn
	} // method extGcd
	/**
	 * Inv:  m, n > 0, m = [m/n]n + r, 0 ≤ r < n,
	 *       MCD(m,n) = MCD(m,n), m = m+vn, n = jn
	 *       
	 * -->   r = m - [m/n]n = m mod n
	 * 
	 * -->   m = m+vn
	 * 
	 * -->   v = 0,  j = 1
	 * 
	 * 
	 * 
	 * Inv:  x, y > 0, x = qy + r, 0 ≤ r < y,
	 *       MCD(x,y) = MCD(m,n), x = um+vn, y = im+jn
	 *       
	 * Inv': y, y' > 0, y = q'y' + r', 0 ≤ r' < y',
	 *       MCD(y,y') = MCD(m,n), x = u'm+v'n, y = i'm+j'n
	 * 
	 * Inv': y, r > 0, y = q'r + r', 0 ≤ r' < r,
	 *       MCD(y,r) = MCD(m,n), x = im+v'n, r = i'm+j'n
	 *        
	 *       s = u - qi
	 *    
	 *    
	 * Inv': y, r > 0, y = q'r + r', 0 ≤ r' < r,
	 *       MCD(y,r) = MCD(m,n), x = im+v'n, r = (u-qi)m+j'n
	 *        
	 *       t = v - Z
	 *       q' = x' / y'
	 *       q' = [y/r]
	 *       j' = t = v - z
	 *       r' = y - [y/r]r = y mod r = x' mod y'
	 *       v' = j
	 *       r = um - qim + j'n = um - qim + (v-Z)'n = um+vn - q(im) - Zn
	 *         = um+vn - ( q(im) + Zn )
	 *         = x - ( q(im) + Zn)
	 *          
	 *       sappiamo che  x = qy + r
	 *       quindi  r = x-qy
	 *        
	 *       qy = q(im) + Zn
	 *        
	 *       se Z = qj
	 *        
	 *       qy = q(im + jn)
	 *        
	 * Post: MCD(m,n) = im + jn = MCD(x,y) = y = im+jn  -->  y = MCD(x,y)
	 *        
	 */
	
	public static long q(int i, int j, boolean b) { // i, j >= 0
		if (b) {
			if (i * j == 0) {
				return i + j + 1;
			} else {
				return q(i - 1, j, b) + q(i, j - 1, b) + q(i, j, !b);
			}
		} else {
			if (i * j == 0) {
				return 1;
			} else {
				return q(i - 1, j, b) + q(i, j - 1, b);
			}
		}
	} // method q

	public static long qBU(int i, int j, boolean b) { // i, j >= 0
		long[][][] h = new long[i + 1][j + 1][2];

		for (int x = 0; x <= i; x++) {
			for (int y = 0; y <= j; y++) {
				for (int z = 0; z < 1; z++) {
					if (z == 1) {
						if (x * y == 0) {
							h[x][y][z] = x + y + 1;
						} else {
							h[x][y][z] = h[x - 1][y][z] + h[x][y - 1][z] + h[x][y][1 - z];
						}
					} else {
						if (x * y == 0) {
							h[x][y][z] = 1;
						} else {
							h[x][y][z] = h[x - 1][y][z] + h[x][y - 1][z];
						}
					}
				}
			}
		}
		return h[i][j][b ? 1 : 0];
	} // method qBU

	public static long qBU1(int i, int j, boolean b) { // i, j >= 0
		long[][][] h = new long[i + 1][j + 1][2];

		for (int x = 0; x <= i; x++) {
			for (int y = 0; y <= j; y++) {
				if (x * y == 0) {
					h[x][y][0] = 1;
					h[x][y][1] = x + y + 1;
				} else {
					h[x][y][0] = h[x - 1][y][0] + h[x][y - 1][0];
					h[x][y][1] = h[x - 1][y][1] + h[x][y - 1][1] + h[x][y][0];
				}
			}
		}
		return h[i][j][b ? 1 : 0];
	} // method qBU1
	
	public static int lcm(int m, int n) {
		int x = m;							// Pre:  m,n > 0
		int y = n;
		
		while (x!=y) {						// Inv:  0 < x, y ≤ mcm(m,n), x % m = 0, y % n = 0
											// Term: 2 * mcm(m,n) - x - y
			if (x < y) {
				int s = y + m - 1;
				x = s - (s % m);
			} else {
				int s = x + n - 1;
				y = s - (s % n);
			}
		}
		return x;							// Post: x = mcm(m,n)
	} // method lcm
	/**
	 * Inv:  0 < x, y ≤ mcm(m,n),  x % m = 0,  y % n = 0
	 * 
	 * 
	 * Inv': 0 < x', y' ≤ mcm(m,n),  x' % m = 0,  y' % n = 0
	 * 
	 * (a) x < y
	 * 	  
	 *     s = y+m-1
	 *     x' = s - Z
	 * 
	 * Inv': 0 < y+m-1 - Z, (y+m-1 - Z) % m = 0
	 * Inv': 0 < y+m-1 - Z, (y-1 - Z + m) % m = 0
	 * 
	 * y - Z = (q-1)m + 1
	 * Z = y - (q-1)m - 1
	 * 
	 * Z = s % m
	 */

	public static void main(String[] args) {
		int n1 = 20, n2 = 3;
		int[] mcd = extGcd(n1, n2);
		for (int i = 0; i < mcd.length; i++) {
			System.out.println(mcd[i]);
		}
		System.out.println("MCD tra " + n1 + " e " + n2 + ": " + ((mcd[0]*n1)+(mcd[1]*n2)));
		
		System.out.println(qBU(4, 4, false));
		System.out.println(lcm(2,3));
	} // method main

}
