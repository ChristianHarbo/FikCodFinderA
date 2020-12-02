import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintResult {
	public static void printOutResult(ArrayList<String> correctResultArray, ArrayList<String> erroResultArray, String fileName) throws IOException {
	//// Out put

			// Correct
			for (String i : correctResultArray) {
					System.out.println(i);
			}

			// line between Correct and Error on Console
			System.out.println("\r____________________________________________\r\r");

			// Whid Error
			for (String i : erroResultArray) {
				System.out.println(i);
		}
		    
		    BufferedWriter theFile = new BufferedWriter(new FileWriter("D://"+fileName+".txt", false) );
		                                  //Set true for append mode
		    for (String s : erroResultArray) {
		    	theFile.newLine();   //Add new line
		    	theFile.write(s);
		    }
		    
		    theFile.newLine();
		    theFile.newLine();
		    theFile.write("____________________________________________");
		    theFile.newLine();
		    theFile.newLine();
		    
		    for (String s: correctResultArray) {
		    	theFile.newLine();   //Add new line
		    	theFile.write(s);
		    }
		    theFile.close();

	}

}
