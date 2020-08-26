package esame;

public class Esame {

	public static void prova() {
		int[] v = new int[] { 1, 2, 3, 4, 5, 6 };

		int n = v.length;

		if (n > 2) {

			int[] x = new int[] { v[n - 2], v[n - 1] };

			for (int i = n - 3; i >= 0; i = i - 1) {

				v[i + 2] = v[i];

			}

			v[1] = x[1];
			v[0] = x[0];

		}

		for (int i = 0; i < v.length; i++) {
			System.out.println(i + ": " + v[i]);
		}

		if (n > 2) {

			int[] x = new int[] { v[0], v[1] };

			for (int i = 0; i < n - 2; i++) {

				v[i] = v[i + 2];

			}

			v[n - 1] = x[1];
			v[n - 2] = x[0];

		}

		for (int i = 0; i < v.length; i++) {
			System.out.println(i + ": " + v[i]);
		}

	}

	public static long rec(int x, int y, int z) { // 1 <= x, y <= z

		if ((x > 1) && (y < z)) {

			return rec(x - 1, y, z) + x * rec(x, y + 1, z);

		} else {

			return 1;

		}

	}

	public static long recBU(int x, int y, int z) { // 1 <= x, y <= z
		long h[][][] = new long[x + 1][y + 1][z + 1];

		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				for (int k = 0; k <= z; k++) {
					if ((x > 1) && (y < z)) {
						h[i][j][k] = rec(x - 1, y, z) + x * rec(x, y + 1, z);
					} else {
						h[i][j][k] = 1;
					}
				}
			}
		}

		return h[x][y][z];

	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rec(7, 4, 13));
		System.out.println(recBU(7, 4, 13));
	}

}
