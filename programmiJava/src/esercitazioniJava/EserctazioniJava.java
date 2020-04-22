package esercitazioniJava;

public class EserctazioniJava {

	/*
	(define btr-succ  ; val: stringa di -/./+
	  (lambda (btr)   ; btr: stringa di -/./+
	    (let ((n (string-length btr))) ; (brt = "." oppure inizia con "+")
	      (let ((lsb (string-ref btr (- n 1))))
	        (if (= n 1)
	            (if (char=? lsb #\+)
	                "+-"
	                "+")
	            (let ((pre (substring btr 0 (- n 1))))
	              (if (char=? lsb #\+)
	                  (string-append (btr-succ pre) "-")
	                  (string-append pre (if (char=? lsb #\-) "." "+"))
	                  )
	              )
	            )
	        )
	      )
	    )
	  )*/
	public static String btrSucc(String btr) {
		int n = btr.length();
		char lsb = btr.charAt( n-1 );
		
		if ( n == 1 ) {
			if ( lsb == '+' ) {
				return "+-";
			} else {
				return "+";
			}
		} else {
			String pre = btr.substring(0, n-1);
			if ( lsb == '+' ) {
				return( btrSucc(pre) + "-" );
			} else if( lsb == '-' ) {
				return( pre + "." );
			} else {
				return( pre + "+" );
			}
		}
	}
	
	/* Complemento a uno:
	(define bit-complement   ; val: stringa
	  (lambda (bit)          ; bit: stringa
	    (if (string=? bit "0")
	        "1"
	        "0"
	        )))
	(define ones-complement  ; val: stringa di 0/1
	  (lambda (bin)          ; bin: stringa di 0/1
	    (if (string=? bin "")
	        ""
	        (string-append
	         (ones-complement (substring bin 0 (- (string-length bin) 1)))
	         (bit-complement (substring bin (- (string-length bin) 1)))
	         ))
	    ))*/
	public static String bitComplement(String bit) {
		if ( bit.compareTo("0") == 0 ) {
			return "1";
		} else {
			return "0";
		}
	}
	public static String onesComplement(String bin) {
		if( bin.compareTo("") == 0 ) {
			return "";
		} else { 
			return(onesComplement(bin.substring(0, bin.length() - 1)) + bitComplement(bin.substring(bin.length() - 1)));
		}
	}
	public static String onesComplementv2(String bin) {
		if( bin.compareTo("") == 0 ) {
			return "";
		} else { 
			String s = "";
			for( int i = 0; i < bin.length(); i++ ) {
				s = s + bitComplement(Character.toString(bin.charAt(i)));
			}
			return s;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("onesComplement: " + onesComplementv2("1001"));
		System.out.println("onesComplementv2: " + onesComplementv2("1001"));
		System.out.println("btrSucc: " + btrSucc("+-"));
	}

}
