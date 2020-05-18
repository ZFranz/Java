package huffman;

import java.util.*;
import huffman_toolkit.*;

/**
 * 
 * @author zhouf
 *
 */
public class Huffman {

	private static final int CHARS = InputTextFile.CHARS; // numeri di caratteri ASCII da 0 a 127

	public static int[] freeHistogram(String src) {
		int[] freq = new int[CHARS]; // associo il numero dell'array con il corrispettivo nella codifica ASCII

		for (int i = 0; i < CHARS; i++) { // inizializzo l'array
			freq[i] = 0;
		}

		InputTextFile in = new InputTextFile(src);

		while (in.textAvailable()) {
			char c = in.readChar();
			freq[c]++;
		}
		in.close();

		return freq;
	} // method freeHistogram

	public static Node huffmanTree(int[] freq) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();

		// ----- controllo l'occorenza di ogni carattere
		for (int i = 0; i < CHARS; i++) {
			if (freq[i] > 0) { // creo un nuovo albero solo con caratteri presenti
				Node n = new Node((char) i, freq[i]);
				q.add(n);
			}
		}
		while (q.size() > 1) {
			Node l = q.poll();
			Node r = q.poll();
			Node n = new Node(l, r);

			q.add(n);
		}
		return q.poll();
	} // method huffmanTree

	public static String[] codeTable(Node root) {
		String[] codes = new String[CHARS];

		fillTable(root, "", codes);

		return codes;
	} // method codeTable

	private static void fillTable(Node n, String pre, String[] codes) {
		if (n.isLeaf()) {
			char c = n.character();
			codes[c] = pre;
		} else {
			fillTable(n.left(), pre + "0", codes);
			fillTable(n.right(), pre + "1", codes);
		}
	} // method fillTable

	public static String flattenTree(Node n) {
		if (n.isLeaf()) {
			char c = n.character();
			if ((c == '@') || (c == '\\')) {
				return "\\" + c;
			} else {
				return "" + c;
			}
		} else {
			return "@" + flattenTree(n.left()) + flattenTree(n.right());
		}
	} // method flattenTree

	public static void compress(String src, String dst) {
		int[] freq = freeHistogram(src);
		Node root = huffmanTree(freq);
		String[] codes = codeTable(root);

		int size = root.weight(); // dimensione del file sorgente
		String ht = flattenTree(root);

		InputTextFile in = new InputTextFile(src);
		OutputTextFile out = new OutputTextFile(dst);

		out.writeTextLine("" + size);
		out.writeTextLine(ht);
		
		for (int i = 0; i < size; i++) {
			char c = in.readChar();
			out.writeCode(codes[c]); 
		}

		in.close();
		out.close();
	} // method compress

	public static void main(String[] args) {
		String src = "src/huffman/Huffman.java";
		String dst = "src/huffman/dst.txt";
		compress(src, dst);
		/*String[] temp = new String[CHARS];
		temp = codeTable(huffmanTree(freeHistogram(src)));
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				System.out.println("[" + (char) i + "]: " + temp[i]);
			}

		}
		System.out.println(flattenTree(huffmanTree(freeHistogram(src))));*/
	} // method main
	
	// (char)((int)(Math.random()*128))

} // class Huffman
