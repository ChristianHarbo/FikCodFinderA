
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
		FileTesterExists fileExists= new FileTesterExists();
		FikCodeChecker checkFik = new FikCodeChecker();
		
		

		ArrayList<String> correctResultArray = new ArrayList<String>();
		ArrayList<String> erroResultArray = new ArrayList<String>();
		
		
//----------------------------------------------------------------------

		// handeling the file
		try {

			

			///// check if file exists
			String fileAt = fileExists.fileTesterExists();
			System.out.println(fileAt);
			//fileExists.fileTesterExists()
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
				// System.out.println("Vender: " + arrLine[3] + "\tInv: " + arrLine[47] + "\tFik
				// Code: "+" valuta "+ arrLine[46]);
				if (arrLine[46].equals("DKK") || arrLine[46].equals("dkk")) {

					String fikCodeCheakerResul = checkFik.fikCodeChecker(arrLine[55]);

					if (fikCodeCheakerResul.equals("correct")) {
						correctResultArray.add("Vender: " + arrLine[3] + "\tInv: " + arrLine[47] + "\tFik Code: "
								+ arrLine[55] + "\t" + fikCodeCheakerResul);
						System.out.println("Vender: " + arrLine[3] + "\tInv: " + arrLine[47] + "\tFik Code: "
								+ arrLine[55] + "\t" + fikCodeCheakerResul);
					} else {
						erroResultArray.add("Vender: " + arrLine[3] + "\tInv: " + arrLine[47] + "\tFik Code: "
								+ arrLine[55] + "\t" + fikCodeCheakerResul);
						System.out.println("Vender: " + arrLine[3] + "\tInv: " + arrLine[47] + "\tFik Code: "
								+ arrLine[55] + "\t" + fikCodeCheakerResul);
					}

				}

			}

			readFil.close();

			// PrintResult.printOutResult(correctResultArray, erroResultArray, whichFill);

		} catch (Exception e) {

			System.out.println("An error occurred.;o(");
			e.printStackTrace();
		}

	}

}
