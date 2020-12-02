
public class FikCodeChecker {

	public static String fikCodeChecker(String fikCode) {
		// Length of a Fik code -1
		int lengde = 29;
		
		// Length of a Fik code special symbols -1
		int numbersOfNumberInFik = 24;

		int extraLength = 0;

		String nunbersInFik = "";

		boolean ifErro = false;

		if (fikCode.indexOf("71") == 2) {
			ifErro = true;
		} else if (fikCode.indexOf("04") == 2) {
			ifErro = true;
			extraLength++;
			
		}

		if (ifErro == true) {
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
