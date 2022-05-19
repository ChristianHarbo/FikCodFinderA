
public class FikCodeChecker {
	
	public String fikCodeChecker(String fikCode) {
		/*
		 *+71<134329012661031+83677902
		 *+04<2150263480000023+2478250
		 * 
		 */
		
		// Length of a Fik code -1
		int lengde = 29;
		
		// Length of a Fik code special symbols -1
		int numbersOfNumberInFik = 24;
		int isItAZeroFour = 0;
		
		int extraLength = 0;

		String nunbersInFik = "";

		boolean ifErro = false;
		
		// what is after * in the fikcode 
		 
		String  whichTaypOfFikcode= "";
		
		for (int i = 2; i<4; i++)
			whichTaypOfFikcode = whichTaypOfFikcode +fikCode.charAt(i);
		
		
		
		System.out.println(whichTaypOfFikcode);
		
		if (whichTaypOfFikcode != "71") {
			//System.out.println(71);
			ifErro = true;
		} else if (whichTaypOfFikcode != "04") {
			//System.out.println("04");
			isItAZeroFour = 1;
			ifErro = true;
			extraLength++;
			
		}

		if (ifErro 
				== true) {
			// Checking for numbers
			for (int i = 0; i < lengde - 1 + extraLength; i++) {

				if (fikCode.charAt(i) >= '0' && fikCode.charAt(i) <= '9') {
					nunbersInFik += fikCode.charAt(i);
				}
			}
		}
		if (nunbersInFik.length() != numbersOfNumberInFik+extraLength) {
			ifErro = false;
			;
		}

		// Checking if everything is in the right place
		if (fikCode.charAt(1) != '+' && fikCode.charAt(1) != '>') {
			ifErro = false;
			
		} else if (fikCode.charAt(0) != '*' || fikCode.charAt(4) != '<' || fikCode.charAt(20 + extraLength) != '+'
				|| fikCode.charAt(29 + extraLength) != '<') {
			ifErro = false;
			

		}
		if (ifErro) {
			return "correct";
		} else {
			return "Error";
		}
	}
}
