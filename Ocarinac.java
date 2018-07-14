// Ocarina compiler driver

import java.util.*;

public class Ocarinac{
	public static void main(String args[]){
		// No args: Print options
		if(args.length == 0){
			System.out.println("Ocarina compiler options");
			System.out.println("-d\t\tDebug mode");
			System.out.println("-v\t\tVersion Number");
		}
		// Debug mode
		else if(args[0].equals("-d")){
			// If nothing else, print debug menu options
			if(args.length == 1)
			{
				System.out.println("Ocarina compiler debug options");
				System.out.println("-t\t\tTokenizer Mode");
			}
			// Process the file in debug mode
			// Will add more options later
			else if(args.length == 3){
				// Tokenizer mode
				if(args[1].equals("-t")){
					String filename = args[2];
					FileInputStream stream = new FileInputStream(filename);
					InputStreamReader reader = new InputStreamReader(stream);
					
				}
				// Error
				else{
					System.out.println("Ocarina error: Invalid flag or filename");
				}
			}
			// Error
			else{
				System.out.println("Ocarina error: Invalid flag or filename");
			}
		}
		else if(args[0].equals("-v")){
			System.out.println("Ocarina compiler version 0.1");
		}
		// Regular compiler mode (will change later)
		else if(args.length == 2){

		}
		// Error
		else{
			System.out.println("Ocarina error: Invalid flag or file name");
		}
	}
}