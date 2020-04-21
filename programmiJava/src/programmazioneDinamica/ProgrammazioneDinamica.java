package programmazioneDinamica;

public class ProgrammazioneDinamica {
	
	public static int fib( int n ) {	// n>0
		if ( n < 2 ) {
			return 1;
		} else {
			return fib( n-2 ) + fib( n-1 );
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Num di fibonacci: " + fib(50));
	}

}
