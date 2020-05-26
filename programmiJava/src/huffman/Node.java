package huffman;

/**
 * Node n = new Node(c, w); c:char, w:weight Node p = new Node(l, r);
 * 
 * Node q;
 * 
 * q.isLeaf() : boolean
 * 
 * q.character() : char q.weight() : int
 * 
 * q.left() : Node q.right() : Node
 * 
 * @author zhouf
 *
 */
public class Node implements Comparable<Node> {
	// ----- Variabili
	private final char character;
	private final int weight;
	private final Node left;
	private final Node right;

	public Node(char chr, int wgt) {
		this.character = chr;
		this.weight = wgt;
		left = null;
		right = null;
	} // constructor Node

	public Node(Node lft, Node rgt) {
		this.character = (char) 0;
		this.weight = lft.weight() + rgt.weight();
		this.left = lft;
		this.right = rgt;
	}

	public boolean isLeaf() {
		return (left == null); // se uno dei 2 e' indefinito, anche l'altro e' indefinito
	} // method isLeaf

	public char character() {
		return character;
	} // method character

	public int weight() {
		return weight;
	} // method weight

	public Node left() {
		return left;
	} // method left

	public Node right() {
		return right;
	} // method right

	public int compareTo(Node n) {
		if (weight < n.weight) {
			return -1;
		} else if (weight == n.weight) {
			return 0;
		} else { // weight > n.weight
			return +1; // mi interessa il segno, non il valore
		}
	} // method compareTo

	public String toString() {
		if (isLeaf()) {
			if ((character() == '@') || (character() == '\\')) {
				return "\\" + character() + ":" + weight();
			} else {
				return character() + ":" + weight();
			}
		} else {
			return "@:" + weight();
		}
	} // method toString

} // class Node
