//WordCtAvgLen
//Authors: Devon Stedronsky & Patrick Lee Walker
//Date last modified: 9/26/2017

//reads a .txt or .dat file specified by user input and displays word count and average word length

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Test file: TestWordCt.txt

public class WordCtAvgLen {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//PROMPT LOOP
		int validExtFlag = 0;
		
		while (validExtFlag == 0) {
			
		//Prompt for file name
		Scanner userScan = new Scanner(System.in);
		System.out.println("Enter filename: ");
		String filename = userScan.nextLine().trim();
		File f = new File(filename);
		
		//Checking for existing/readable file
		if (f.exists() == false || f.canRead() == false) {
			System.out.println("File not found or not readable.");
			continue;
		}
		
		//Checking for valid file extension
		String path = f.getPath();
		int dot = path.lastIndexOf(".");
	    String extension = path.substring(dot + 1);
	    if (extension.equals("txt") == true || extension.equals("dat") == true) {
	    	validExtFlag = 1;
	    }
	    else {
	    	System.out.println("Invalid file name. A valid file name looks like: filename.txt or filename.dat");
	    	continue;
	    }

	    double wordCount = 0;	//Running total word count
	    double wordLength = 0;	//Running total character count
	    
	    //Scanning file
		Scanner fileScan = new Scanner(f);
	    
		while (fileScan.hasNextLine()) {
		String line = fileScan.nextLine();
		String [] tokenArray = line.split(" ");
		
		//Count words excluding empty lines
		if (line.isEmpty() == false) {
			wordCount = wordCount + tokenArray.length;
		}
		//Count characters in each word	
		for (int i = 0; i < tokenArray.length; i++) {
			String token = tokenArray[i];
			wordLength = wordLength + token.length();
			}
		}
		
		fileScan.close();
		
		System.out.println("Word Count: " + wordCount + "\n" + "Average Word Length: " + (wordLength / wordCount));

		}
		return;
	}
}
