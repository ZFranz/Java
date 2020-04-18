package programmiJava;

public class PrimoProgrammaJava {
	
	/* calcolo della superficie totale del cilindro
	(define sup-tot-cil   ; val: reale
	  (lambda (r h)       ; r, h: reali positivi
	    (* 2 pi r (+ r h))
	    )
	  )*/
	public static double supTotCil(double r, double h) {
        return(2 * Math.PI * r * (r + h));
    }
	
	/*calcolo della superficie totale del cono
	(define sup-tot-cono
	  (lambda (r h)
	    (* pi r (+ r (sqrt (+ (* r h) (* r h))))))
	  )*/
	public static double supTotCono(double r, double h) {
		return(Math.PI * r * (r + (Math.sqrt((r * h) + (r * h))))); 
	}

	/* cambio di una parola maschile al plurale
	(define plurale-sm
	  (lambda (s)
	    (string-append (substring s 0 (- (string-length s) 1)) "i")
	    )
	  )*/
    public static String pluraleSm(String s) {
        return(s.substring(0, s.length() -1) + "i");
    }

    /* cambio di una parola femminile al plurale
    (define plurale-sf
      (lambda (s)
        (string-append (substring s 0 (- (string-length s) 1)) "e")
        )
      )*/
    public static String pluraleSf(String s) {
        return(s.substring(0, s.length() -1) + "e");
    }

    /* controllo se una parola è femminile o no
    (define femminile?  ; val: booleano
      (lambda (s)       ; s: stringa
        ;(string=? (substring s (- (string-length s) 1 )) "a")
        (char=? (string-ref s (- (string-length s) 1 )) #\a)
        )
      )*/
    public static boolean femminile(String s) {
        return(s.charAt(s.length() - 1) == 'a');
    }

    /* cambio di una parola da singolare a plurale
    (define plurale        ; val: stringa
      (lambda (s)          ; s: stringa (sostantivo regolare)
        (if (femminile? s)
            (plurale-sf s)
            (plurale-sm s)
            )
        )
      )*/
    public static String plurale(String s) {
        if (femminile(s)){
            return(pluraleSf(s));
        } else {
            return(pluraleSm(s));
        }
        // return(femminile(s)? pluraleSf(s) pluraleSm(s));   //metodo alternativo per restituire i risultati dell'if
    }
    
    /*
    (define b0 (* 100 (expt 2 +1/4)))   ; nei positivi il + si può omettere
    (define b1 (* 100 (expt 2 -1/4)))
    (define b       ; val: reali
      (lambda (k)   ; k intero non negativo
        ;(if (< k 2)
        ;   (if (= k 0) b0 b1)
        ;   (/ (b (- k 2)) 2)
        ;   )
        (cond ((= k 0) b0)
              ((= k 1) b1)
              (else (/ (b (- k 2)) 2))
              )
        )
      )*/
    private static final double b0 = (100 * Math.pow(2, +0.25));
    private static final double b1 = (100 * Math.pow(2, -0.25));
    public static double b(int k) {
        switch(k) {
            case 0:
                return b0;
            case 1:
                return b1;
            default:
                return (b(k - 2) / 2);
        }
    }
    
    /* rappresentazione ternaria bilanciata in base decimale
    (define btd-val    ; val: + oppure - oppure .
      (lambda (btd)    ; btd: carattere
        (cond ((char=? btd #\-) -1)
              ((char=? btd #\.) 0)
              (else +1)
              )
        )
      )
    (define btr-val   ; val: intero  btr--> balanced ternary rappresentation
      (lambda (num)   ; num: stringa non vuota di -/./+
        (let ( (k (- (string-length num) 1)) )
          (let ( (pre (substring num 0 k)) (lsb (string-ref num k)) )
            (if (= k 0)
                (btd-val lsb)   ; balanced ternary digit
                (+ (* 3 (btr-val pre)) (btd-val lsb))
                )
            )
          )
        )
      )*/
    public static int btdVal(char btd) {
        switch(btd){
            case '-':
                return -1;
            case '.':
                return 0;
            default:
                return 1;
        }
    }
    /*public static int btrVal(String num) {
        int k = num.length() - 1;
        String pre = num.substring(0, k);
        char lsb = num.charAt(k);
        
        if (k == 0) {
            return btdVal(lsb);
        } else {
            return(btrVal(pre) * 3 + btdVal(lsb));
        }
    }*/
    public static int btrVal(String num) {
        int n = num.length();
        int v = 0;
        
        for (int i = 0; i < n; i++) {
        	v = 3 * v + btdVal(num.charAt(i));
        }
        return v;
    }
    

    /* rappresentazione da decimale in ternaria bilanciata
    (define btr-rep   ; val: stringa non vuota di -/./+
      (lambda (n)     ; n: intero qualsiasi
        (if (<= (abs n) 1)
            (btd-rep n)
            (let ( (q (quotient n 3)) (r (remainder n 3)) )
              (cond ((= r -2)
                     (string-append (btr-rep (- q 1)) (btd-rep +1))
                    )
                    ((= r +2)
                     (string-append (btr-rep (+ q 1)) (btd-rep -1))
                    )
                    (else  ; r = -1/0/+1
                     (string-append (btr-rep q) (btd-rep r))
                     )
              )
            )
        )
      )
      )
    (define btd-rep  ; val: stringa
      (lambda (v)    ; v: -1, 0, +1
        (cond ((= v -1) "-") ;-1
              ((= v +1) "+") ;+1
              (else ".")     ;0
          )
        )
      )*/
    public static String btdRep(int num) {
    	switch (num) {
		case -1:
			return "-";

		case +1:
			return "+";
			
		default:
			return ".";
		}
    }
    public static String btrRep(int num) {
    	if (num <= 1) {
			return(btdRep(num));
		} else {
			int q = num / 3;
			int r = num % 3;
			switch (r) {
			case -2:
				return(btrRep(q - 1) + btdRep(+1));
				
			case +2:
				return(btrRep(q + 1) + btdRep(-1));

			default:
				return(btrRep(q) + btdRep(r));
			}
		}
    }
    
    /* nella rappresentazione binaria, se il resto della divisione per 2 è 0, il bit è 0 altrimenti 1
    (define bin-rep  ; val: stringa di 0/1
      (lambda (n)    ; n: intero non negativo
        (let ((q (quotient n 2)) (r (remainder n 2)))
          (let ((lsb (if (= r 0) "0" "1")))
            (if (= q 0)
                lsb
                (string-append (bin-rep q) lsb)
                )
            )
          )
        )
      )*/
    public static String binRep(int num) {
    	int q = num / 2;
    	int r = num % 2;
    	String lsb = "";
    	
    	if (r == 0) {
    		lsb = "0";
    	} else {
    		lsb = "1";
    	}
    	if (q == 0) {
    		return lsb;
    	} else {
    		return(binRep(q) + lsb);
    	}
    }
    
    /* complemento a 1
    (define cmp     ; val: stringa
      (lambda (b)   ; b: string "0" oppure "1"
        (if (string=? b "0")
            "1"
            "0")
        )
      )
    (define compl-1    ; val: stringa
      (lambda (s)      ; s: stringa di 1/0
        (if (> (string-length s) 0)
            (string-append
             (cmp (substring s 0 1))
             (compl-1 (substring s 1))  ; delega la ricorsione, se non viene specificato il secondo parametro, il sistema capisce di dover incrementare di 1
             )
            ""
            )
        )
      )
    (define delega    ; val: stringa
      (lambda (s)     ; s: stringa di 1/0
        (if (> (string-length s) 0)
            (string-append
             (cmp (substring s 0 1))
             (delega (substring s 1))  ; delega la ricorsione, se non viene specificato il secondo parametro, il sistema capisce di dover incrementare di 1
             )
            ""
            )
        )
      )
    (define compl-1b   ; val: stringa
      (lambda (s)      ; s: stringa non vuota di 1/0
        (let ((k (quotient (string-length s) 2)))   ; let --> dichiaro localmente una formula
          (cond ((= (string-length s) 0) "")        ; se la stringa è vuota, stampa nulla
                ((= (string-length s) 1) (cmp s))   ; se la stringa è lunga 1 carattere, fa il cmp
                (else                               ; se la lunghezza è >1 fa la ricorsione del complemento
                 (string-append
                  (delega (substring s 0 k))
                  (delega (substring s k))
                  )
                 )
                )
          )
        )
      )*/
    public static String cmp(String b) {
    	if (b.compareTo("0") == 0) {
    		return "1";
    	} else {
    		return "0";
    	}
    }
    public static String compl1(String s) {
    	int k = s.length();
    	if (k > 0) {
    		return(cmp(s.substring(0, 1)) + compl1(s.substring(1)));
    	} else {
    		return "";
    	}
    }
    public static String delega(String s) {
    	if (s.length() > 0) {
    		return(cmp(s.substring(0, 1)) + delega(s.substring(1)));
    	} else {
    		return "";
    	}
    }
    public static String compl1b(String s) {
    	int k = s.length() / 2;
    	switch (s.length()) {
		case 0:
			return "";
		
		case 1:
			return(cmp(s));

		default:
			return(delega(s.substring(0, k)) + delega (s.substring(k)));
		}
    }
    
    /*
    (define divisibile?  ; val: booleano
      (lambda (n a b)    ; n, a, b: interi non negativi
        (cond ((> a b) false)
            ((= (remainder n a) 0) true)
            (else (divisibile? n (+ a 1) b))
            )
      )
    )
    (define dispari-divisibile?  ; val: booleano
      (lambda (n a b)            ; n, a, b: interi non negativi
        (cond ((> a b) false)
              ((= (remainder n a) 0) true)
              (else (dispari-divisibile? n (+ a 2) b))
              )
        )
      )
    (define primo?
      (lambda (n)
    	(if (even? n)
    	  (= n 2)
    	  (not (dispari-divisibile? n 3 (floor (sqrt n)))))))

    (define lista-primi
      (lambda (m n)
        (cond ((> m n) null)
          ((primo? m) (cons m (lista-primi (+ m 1) n)))
    	  (else (lista-primi (+ m 1) n)))))*/
    public static boolean dispariDivisibile(int n, int a, int b) {
    	if (a > b) {
			return false;
		} else if ((n % a) == 0) {
			return true;
			} else {
				return(dispariDivisibile(n, (a + 2), b));
			}
    }
    public static boolean primo(int n) {
    	if ((n % 2) == 0) {
    		if (n == 2) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return(!(dispariDivisibile(n, 3, (int)(Math.floor(Math.sqrt(n))))));
    	}
    }
  
    // calcolo del massimo comune divisore
    public static int gcd(int x, int y) {
    	/*
    	if (x < y) {
    		return gcd(x, y - x);
    	} else if (x > y) {
    		return gcd(x - y, y);
    	} else {
    		return x;
    	}*/
    	while (x != y) {
	    	if (x < y) {
	    		y = y - x;
	    	} else {
	    		x = x - y;
	    	}
    	}
    	return x;
    	
    }
    
    // calcolo del minimo comune multiplo
    public static int lcm(int x, int y) {
    	
    	int m = x;
    	
    	while (m % y != 0) {
    		m = m + x;
    	}
    	return m;
    }
    
    /*
    (define ufo            ; valore: ?
      (lambda (x)          ; x > 0 naturale
    	(cond ((= x 1) 1)
    		  ((even? x)   ; x pari
    		    (- (* 2 (ufo (quotient x 2))) 1))
    		  (else        ; x dispari
    	    	(+ (* 2 (ufo (quotient x 2))) 1))
    	  )
    	)
      )*/
    public static int ufo(int n) {	// n > 0
    	int[] u = new int[n + 1];
    	
    	u[1] = 1;
    	for(int x = 2; x <= n; x++) {
    		if (x % 2 == 0) {	// x pari
				u[x] = (2 * u[x / 2] - 1);
			} else {			// x dispari
				u[x] = (2 * u[x / 2] + 1);		
			}
    	}
    	return u[n];
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ufo(12));
	}

}
