package lab.codificaHuffman;

import huffman_toolkit.*;
import huffman.Node;
import static huffman.Huffman.*;

public class HuffmanCode {

	private static final int CHARS = InputTextFile.CHARS;

	/**
	 * @param src il file sorgente
	 * @param dst il file destinazione
	 */
	public static void codificaHuffman(String src, String dst) {
		int[] freq = freqHistogram(src);
		Node root = huffmanTree(freq);
		String[] codes = codeTable(root);

		OutputTextFile out = new OutputTextFile(dst);

		out.writeTextLine("CODICE ASCII" + "\t" + "CARATTERE" + "\t" + "OCCORRENZE" + "\t" + "CODICE HUFFMANN" + "\t"
				+ "LUNGHEZZA CODICE");

		for (int i = 0; i < CHARS; i++) { // scorro l'array
			if (freq[i] > 0) { // identifico i valori significativi dell'array
				String codice = codes[i];
				int lunghezza = codice.length();
				out.writeTextLine("\t" + i + "\t\t\t" + ((char) i) + "\t\t\t\t" + freq[i] + "\t\t\t\t" + codice
						+ "\t\t\t\t" + lunghezza);
			}
		}

		out.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		codificaHuffman("InputFile.txt", "OutputFile.txt");
	}

}
