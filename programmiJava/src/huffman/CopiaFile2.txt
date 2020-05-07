package huffman;

import huffman_toolkit.*;

public class IOExamples {

	/**
	 * 
	 * @param src - String, nome del file di input
	 * @param dst - String, nome del file di output
	 * @return number of line
	 */
	public static int copyFile(String src, String dst) {
		// ----- creo e apro i file di input e output
		InputTextFile in = new InputTextFile(src);
		OutputTextFile out = new OutputTextFile(dst);
		int count = 0;

		// ----- finché ho del testo leggo e copio riga per riga
		while (in.textAvailable()) {
			String line = in.readTextLine();
			out.writeTextLine(line);
			count++;
		}

		// ----- chiudo i file di input e output
		in.close();
		out.close();

		// ----- restituisco il numero di righe copiate
		return count;
	} // method copyFilev

	/**
	 * 
	 * @param src - String, nome del file di input
	 * @param dst - String, nome del file di output
	 * @return number of characters
	 */
	public static int copyFilev2(String src, String dst) {
		// ----- creo e apro i file di input e output
		InputTextFile in = new InputTextFile(src);
		OutputTextFile out = new OutputTextFile(dst);
		int count = 0;

		// ----- finché ho del testo leggo e copio riga per riga
		while (in.textAvailable()) {
			char c = in.readChar();
			out.writeChar(c);
			count++;
		}

		// ----- chiudo i file di input e output
		in.close();
		out.close();

		// ----- restituisco il numero di caratteri copiati
		return count;
	} // method copyFilev2

	/**
	 * 
	 * @param src - String, nome del file di input
	 * @param dst - String, nome del file di output
	 * @return number of bits
	 */
	public static int copyFilev3(String src, String dst) {
		// ----- creo e apro i file di input e output
		InputTextFile in = new InputTextFile(src);
		OutputTextFile out = new OutputTextFile(dst);
		int count = 0;

		// ----- finché ho del testo leggo e copio riga per riga
		while (in.bitsAvailable()) {
			int bit = in.readBit(); 
			out.writeBit(bit);
			count++;
		}

		// ----- chiudo i file di input e output
		in.close();
		out.close();

		// ----- restituisco il numero di bit copiati
		return count;
	} // method copyFilev3
	
	/**
	 * 
	 * @param src - String, nome del file di input
	 * @param dst - String, nome del file di output
	 * @return number of bits in ASCII
	 */
	public static int copyFilev4(String src, String dst) {
		// ----- creo e apro i file di input e output
		InputTextFile in = new InputTextFile(src);
		OutputTextFile out = new OutputTextFile(dst);
		int count = 0;

		// ----- finché ho del testo leggo e copio riga per riga
		while (in.bitsAvailable()) {
			String bits = in.readCode(7); 
			out.writeCode(bits);
			count++;
		}

		// ----- chiudo i file di input e output
		in.close();
		out.close();

		// ----- restituisco il numero di bit copiati in codifica ASCII
		return count;
	} // method copyFilev4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "src/huffman/IOExamples.java";
		String dst1 = "src/huffman/CopiaFile1.txt";
		String dst2 = "src/huffman/CopiaFile2.txt";
		String dst3 = "src/huffman/CopiaFile3.txt";
		String dst4 = "src/huffman/CopiaFile4.txt";
		System.out.println("Il file \"" + src+ "\" contiene " + copyFile(src, dst1) + " righe.");
		System.out.println("Il file \"" + src + "\" contiene " + copyFilev2(src, dst2) + " caratteri.");
		System.out.println("Il file \"" + src + "\" contiene " + copyFilev3(src, dst3) + " bit.");
		System.out.println("Il file \"" + src + "\" contiene " + copyFilev4(src, dst4) + " bit in codifica ASCII.");
	}

} // class IOExamples
