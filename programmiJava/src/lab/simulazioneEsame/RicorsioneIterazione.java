package lab.simulazioneEsame;

public class RicorsioneIterazione {

	public static int shortestCodeLength( Node root ) {
		 int sc = ;
		 Stack<Node> stack = new Stack<Node>();
		 Stack<Integer> depth = new Stack<Integer>();
		 stack.push( root );
		 depth.push( 0 );
		 do {
		 Node n = ;
		 int d = ;
		 if ( n.isLeaf() ) {
		 sc = Math.min( sc, d );
		 } else if ( d+1 < ) {




		 }
		 } while ( );
		 return sc;
		 } // method shortestCodeLength

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // method main

}
