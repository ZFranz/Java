package tavolaRotonda;

public class GiuseppeFlavio {

	public static int ultimo(int n) {
		
		TavolaRotonda tr = new TavolaRotonda(n);
		
		while(tr.numeroDiCavalieri() > 1) {
			tr = tr.dopoUscitaCav();
		}
		return tr.cavConLaBrocca();
	}	// method ultimo
	
	public static int ultimo2(int n) {
		
		TavolaRotondav2 tr = new TavolaRotondav2(n);
		
		while(tr.numeroDiCavalieri() > 1) {
			tr = tr.dopoUscitaCav();
		}
		return tr.cavConLaBrocca();
	}	// method ultimo2
	
	public static int ultimo3(int n) {
		
		TavolaRotondav3 tr = new TavolaRotondav3(n);
		
		while(tr.numeroDiCavalieri() > 1) {
			tr = tr.dopoUscitaCav();
		}
		return tr.cavConLaBrocca();
	}	// method ultimo3
	
	public static int test(int n, int repeats) {	// usa TavolaRotonda
		int j = 0;
		long t0 = System.currentTimeMillis();	// start cronometro
		
		for(int i = 0; i < repeats; i++) {
			j = ultimo(n);
		}
		
		long t = System.currentTimeMillis();	// stop cronometro
		
		System.out.println("Test 1\nTempo: " + (t - t0) + "ms");
		
		return j;
	}	// method test
	
	public static int test2(int n, int repeats) {	// usa TavolaRotondav2
		int j = 0;
		long t0 = System.currentTimeMillis();	// start cronometro
		
		for(int i = 0; i < repeats; i++) {
			j = ultimo2(n);
		}
		
		long t = System.currentTimeMillis();	// stop cronometro
		
		System.out.println("Test 2\nTempo: " + (t - t0) + "ms");
		
		return j;
	}	// method test2
	
	public static int test3(int n, int repeats) {	// usa TavolaRotondav3
		int j = 0;
		long t0 = System.currentTimeMillis();	// start cronometro
		
		for(int i = 0; i < repeats; i++) {
			j = ultimo3(n);
		}
		
		long t = System.currentTimeMillis();	// stop cronometro
		
		System.out.println("Test 3\nTempo: " + (t - t0) + "ms");
		
		return j;
	}	// method test3
	
	public static void main(String args[]) {
		System.out.println("Cavaliere n° " + test(10000, 100) + "\n");
		System.out.println("Cavaliere n° " + test2(10000, 100) + "\n");
		System.out.println("Cavaliere n° " + test3(10000, 100) + "\n");
	}
}	// class GiuseppeFlavio