package lab.simulazioneEsame;

public class MatriceSimmetrica {
	public static boolean controlla(int[][] h) {
		int m = h.length;
		int n = h.length;

		for (int i = 0; i < m; i++) {
			for (int j = 0 + i; j < n; j++) {
				if (h[i][j] != h[j][i]) {
					return false;
				}
				if ((i == m - 1) && (j == n - 1)) {
					return true;
				}
			}
		}

		return false;
	} // method controlla

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h[][] = new int[5][5];
		h[0][0] = 0;
		h[0][1] = 1;
		h[0][2] = 0;
		h[0][3] = 1;
		h[0][4] = 1;
		h[1][0] = 1;
		h[1][1] = 1;
		h[1][2] = 1;
		h[1][3] = 0;
		h[1][4] = 1;
		h[2][0] = 0;
		h[2][1] = 1;
		h[2][2] = 0;
		h[2][3] = 0;
		h[2][4] = 1;
		h[3][0] = 1;
		h[3][1] = 0;
		h[3][2] = 0;
		h[3][3] = 1;
		h[3][4] = 1;
		h[4][0] = 1;
		h[4][1] = 1;
		h[4][2] = 1;
		h[4][3] = 1;
		h[4][4] = 1;


		for (int i = 0; i < h.length; i++) {
			for (int j = 0; j < h.length; j++) {
				System.out.print(h[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(controlla(h));
	} // method main

}
