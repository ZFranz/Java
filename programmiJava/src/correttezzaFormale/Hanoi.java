package correttezzaFormale;

import java.util.Stack;

public class Hanoi {

	public static String hanoiMovesIter(int n) {

		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] { n, 1, 2, 3 });

		String moves = "";
		int s, d, t;

		while (!stack.isEmpty()) {

			int[] args = stack.pop();
			n = args[0];
			s = args[1];
			d = args[2];
			t = args[3];
			if (n == 1) {
				moves = moves + " " + s + "->" + d;
			} else {
				stack.push(new int[] { n - 1, t, d, s });
				stack.push(new int[] { 1, s, d, t });
				stack.push(new int[] { n - 1, s, t, d });
			}
		}
		return moves;
	} // method hanoiMovesIter

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hanoiMovesIter(3));
	} // method main

} // class Hanoi
