package esercizi;

public class es {

	private static final IntList UNKNOWN = null;

	public static int q(int[] s) { // s.length > 0
		int n = s.length;
		int[] t = new int[n];
		t[0] = s[0];
		for (int k = 1; k < n; k = k + 1) {
			int i = k - 1;
			while ((i >= 0) && (t[i] > s[k])) {
				t[i + 1] = t[i];
				i = i - 1;
			}
			t[i + 1] = s[k];
		}
		return qRec(s, t, n, 0, 0);
	}

	private static int qRec(int[] s, int[] t, int n, int i, int j) {
		if ((i == n) || (j == n)) {
			return 0;
		} else if (s[i] == t[j]) {
			return 1 + qRec(s, t, n, i + 1, j + 1);
		} else {
			return Math.max(qRec(s, t, n, i + 1, j), qRec(s, t, n, i, j + 1));
		}
	}

	public static int q_b(int[] s) {
		int vector[][] = new int[s.length + 1][s.length + 1];
		for (int i = 0; i <= s.length; i++) {
			for (int j = 0; j <= s.length; j++) {
				vector[i][j] = -1;
			}
		}

		int n = s.length;
		int[] t = new int[n];
		t[0] = s[0];
		for (int k = 1; k < n; k = k + 1) {
			int i = k - 1;
			while ((i >= 0) && (t[i] > s[k])) {
				t[i + 1] = t[i];
				i = i - 1;
			}
			t[i + 1] = s[k];
		}

		return qRec_b(s, t, n, 0, 0, vector);
	}

	private static int qRec_b(int[] s, int[] t, int n, int i, int j, int[][] vec) {
		if (vec[i][j] == -1) {
			if ((i == n) || (j == n)) {
				vec[i][j] = 0;
			} else if (s[i] == t[j]) {
				vec[i][j] = 1 + qRec_b(s, t, n, i + 1, j + 1, vec);
			} else {
				vec[i][j] = Math.max(qRec_b(s, t, n, i + 1, j, vec), qRec_b(s, t, n, i, j + 1, vec));
			}
		}
		return vec[i][j];
	}

	public static IntList lis(IntList s) {
		IntList h[] = new IntList[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			h[i] = null;
		}

		return lisRec(s, 0, h);
	}

	public static IntList lisRec(IntList s, int t, IntList h[]) {
		int k = s.length();
		
		if (h[k] == UNKNOWN) {
			if (s.isNull()) {
				h[k] = new IntList();
			} else if (s.car() <= t) {
				h[k] = lisRec(s.cdr(), t, h);
			} else {
				h[k] = longer( new IntList( s.car(), lisRec( s.cdr(), s.car(), h ) ),
						 lisRec( s.cdr(), t, h));
			}
		}
		
		return h[k];
	}

	public static IntList longer(IntList u, IntList v) {
		if (u.length() < v.length()) {
			return v;
		} else {
			return u;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = new int[] { 1, 2, 10, 2, 50, 25, 3 };
		IntList list = new IntList();
		list = list.cons(12);
		list = list.cons(2);
		list = list.cons(25);
		list = list.cons(51);
		list = list.cons(1);
		list = list.cons(14);
		list = list.cons(23);
		list = list.cons(33);
		list = list.cons(15);
		list = list.cons(3);
		list = list.cons(29);
		list = list.cons(3);
		System.out.println(lis(list).car());
		System.out.println(lis(list).cdr().car());
		System.out.println(lis(list).cdr().cdr().car());
		System.out.println(lis(list).cdr().cdr().cdr().car());
		//System.out.println(q_b(n));
	}

}
