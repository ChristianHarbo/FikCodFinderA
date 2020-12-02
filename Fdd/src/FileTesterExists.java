import java.io.*; 
import java.util.Scanner;

public class FileTesterExists {
	//private static Scanner input;

	
	
	///// check if file exists
	public String fileTesterExists() {
		Scanner userInput = new Scanner(System.in);
		
		//Wher is the file at?
		char answer = 'f';
		String fileAt = "D:\\"; 
		System.out.print("What is the fils name: ");
		String whichFill = userInput.nextLine();
		
		
		//calling the fill the first time 
		File fill = new File(fileAt+whichFill+".txt"); 
		
		// check if file exists if true, sends back feedback
		if (fill.exists())
			return fileAt+whichFill+".txt";
		
		//If false  
		
		
		while (!fill.exists()) {
			System.out.print("An error has occurred.\n");
			
			// are we looking at the correct place? need user input y/n.
			System.out.print(whichFill + ".txt is not at the location of " + fileAt + "\nIs this the correct adress? (y/n) ");
			answer = userInput.nextLine().charAt(0);
			
			// user input is Yes
			if (answer == 'Y' || answer == 'y') {
				System.out.print("\nWhat is the corect fils name: ");
				whichFill = userInput.nextLine();
				
			// User input is No
			} else if (answer == 'N' || answer == 'n') {
				System.out.print("\nWhat is the corect adress: ");
				fileAt = userInput.nextLine();
				System.out.print("\nWhat is the corect fils name: ");
				whichFill = userInput.nextLine();
				
				
			// if user input is Wrong
			} else {
				System.out.print("\nYour input, can not be recognized.\nPlease tayagen. \n");
				continue;
			}

						
			
			fill = new File(fileAt+whichFill+".txt");
		} 
		
		return fileAt+whichFill+".txt";
	
		
	}
}