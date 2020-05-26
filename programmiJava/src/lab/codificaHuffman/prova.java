package lab.codificaHuffman;

public class prova {
	public static void main(String[] args) {
		int [] v1 = new int[10];
		for (int i = 0; i < v1.length; i++) {
			v1[i] = i;
		}
		for (int i = 0; i < v1.length; i++) {
			System.out.println("v1[" + i + "]: " + v1[i]);
		}
		
		int[] v2 = new int[v1.length + 1];
		for (int i = 0; i < v1.length; i++) {
			v2[i] = v1[i];
		}
		for (int i = 0; i < v2.length; i++) {
			System.out.println("v2[" + i + "]: " + v2[i]);
		}
	}
 }
