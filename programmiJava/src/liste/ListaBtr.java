package liste;

import esercitazioniJava.EserctazioniJava;

public class ListaBtr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		String btr = ".";
		StringSList sl = new StringSList(btr, StringSList.NULL_STRINGLIST);
		
		for(int i = 1; i < n; i++) {
			btr = EserctazioniJava.btrSucc(btr);
			sl = sl.append(new StringSList(btr, StringSList.NULL_STRINGLIST));
		}
		
		System.out.println(sl);
	}

}
