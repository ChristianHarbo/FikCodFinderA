
// things to due..
/*
 * If ".txt"
 * If file is not in the correct plays
 * 	-make a way to change where the file is that have to be checked.
 *  -save the change new addres where the new fill is going forward.
 
 * Save the result as a file
 */

import java.io.*; // Import the File class
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FikCode {

	public static void main(String[] args) throws IOException {

		// open classes
		FileTesterExists fileExists = new FileTesterExists();
		FikCodeChecker checkFik = new FikCodeChecker();

		ArrayList<String> correctResultArray = new ArrayList<String>();
		ArrayList<String> erroResultArray = new ArrayList<String>();

//----------------------------------------------------------------------

		// handeling the file
		try {

			///// check if file exists
			String fileAt = fileExists.fileTesterExists();
			System.out.println(fileAt);
			// fileExists.fileTesterExists()
			File oppeFill = new File(fileAt);

			Scanner readFil = new Scanner(oppeFill);

			while (readFil.hasNextLine()) {

				// Opnig the ichline of the file
				String oneLineStrFromFill = readFil.nextLine();

				// puting linfrom fil in to array
				String[] arrLine = oneLineStrFromFill.split("\t");

				/*
				 * List of where thinks are 3 Taps thene vendor No. 46 Taps thene DKK 48 Taps
				 * thene invoice No. 55 Taps thene Fik code.
				 */

				// Check if the arrLine is long enough.
				if (arrLine.length > 17) {
					int fikcodeAt = 27;
					int vendorNoAt = 0;
					int currencyAt = 18;
					int InvNoAt = 19;

					String theFikcode = " ";

					if (arrLine[currencyAt].equals("DKK") || arrLine[currencyAt].equals("dkk")) {

						String isTheFikcodeCorrect = "k";

						// is The Fikcode on the line.
						if (arrLine.length >= 26) {

							// here is the Fikcode being checked if id is living up to the parameters.
							isTheFikcodeCorrect = checkFik.fikCodeChecker(arrLine[fikcodeAt]);
							theFikcode = arrLine[fikcodeAt];
						} else {
							isTheFikcodeCorrect = "\t\t\t\tError";
						}

						String TextToEnduser = ("Vender: " + arrLine[vendorNoAt] + "\tInv: " + arrLine[InvNoAt]
								+ "\tFik Code: " + theFikcode + "\t" + isTheFikcodeCorrect);

						if (isTheFikcodeCorrect.equals("correct")) {
							correctResultArray.add(TextToEnduser);
						} else {
							erroResultArray.add(TextToEnduser);

						}

					}
				}

			}

			readFil.close();

		} catch (Exception e) {

			System.out.println("An error occurred.;o(");
			e.printStackTrace();
		}

		// out put the data for the user
		for (String outPutcorrect : correctResultArray) {
			System.out.println(outPutcorrect);
		}
		System.out.println("\n____________________________________________________________________________\n\n");
		for (String outPuterros : erroResultArray) {
			System.out.println(outPuterros);
		}
	}

}
