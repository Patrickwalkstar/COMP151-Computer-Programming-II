//ChangeStyle.java
//Authors: Devon Stedronsky & Patrick Lee Walker
//Date last modified: 9/26/2017

//Changes next-line brace style document to same-line brace style and saves to the same file.
//File name must be a full extension from current library

//The program works by scanning for open bracket lines and editing the line to a complete file string for writing.
//It assumes the file is correctly written in next line bracket style. 
//If no "{" lines are found it is assumed to already be in same-line brace style.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Test Read File:
//src/TestCS.java

//Test Write File
//src/WriteCS.java

public class ChangeStyle {
	
	public static void main(String[] args) throws FileNotFoundException {

		int validFlag = 0;
		
		//Prompt for file name
		Scanner userScan = new Scanner(System.in);
		
		while (validFlag == 0) {
		System.out.println("Enter filename: ");
		String filename = userScan.nextLine().trim();
		File f = new File(filename);
		
		//File not found exception -- continue prompting
		try {
			Scanner fileTest = new Scanner(f); 
			fileTest.close();
		}
		catch (java.io.FileNotFoundException ex){
			System.out.println("Bad FileName");
			validFlag = 0;
			continue;
		}
		
		//Open file and scan lines. Mark line numbers for "{"
		Scanner fileScan = new Scanner(f);

		int lineNumber = 0;	//current line number
		ArrayList<String> loca = new ArrayList();	//array list of "{" line numbers
		String line; 	//current line
		
		//record line numbers for "{" lines
		while (fileScan.hasNextLine()) {
			line = fileScan.nextLine().trim();
			lineNumber = lineNumber + 1;
			if (line.equals("{")) {
				loca.add(Integer.toString(lineNumber));
			}
		}
		
		if (loca.isEmpty() == true) {
			System.out.println("File already in correct style");
			fileScan.close();
			return;
		}

		fileScan.close();
		
		//Edit each line according to results from first scan
		Scanner fileRead = new Scanner(f);
		
		String readLine;
		String token;
		ArrayList <String> completeFile = new ArrayList();
		int currentLine = 0;
		
		while (fileRead.hasNextLine()) {
			
			String editedLine = "";
			
		readLine = fileRead.nextLine();
		currentLine = currentLine + 1;
		
		//omit { characters in each line
		String [] tokenArray = readLine.split("");
		for (int j = 0; j < tokenArray.length; j++) {
			token = tokenArray[j];
			if (token.equals("{") == false)	{
				editedLine = editedLine + token;
			}
		}
		
		//Add brackets to previous line and edit to blank line
		for (int i = 0; i < loca.size(); i++) {
			//lines before { line add the same line bracket
			if (currentLine == Integer.parseInt(loca.get(i)) - 1) {
				editedLine = editedLine + "  {"; 
			}
			//{ lines are now blank
			if (currentLine == Integer.parseInt(loca.get(i))) {
				editedLine = "";
			}
		}
		
		//copy non { lines - eliminates extra spaces vacated by {
		if (readLine.equals("{") == false) {
		completeFile.add(editedLine + "\n");	
		}
		}
		
		System.out.println(completeFile);
		fileRead.close();
		
		//Write file
		PrintWriter editor = new PrintWriter(f);
		
		for (int k = 0; k < completeFile.size(); k++) {
			editor.write(completeFile.get(k));	
		}
	
		editor.close();
		
		//Exit Program
		validFlag = 1; 
		return;
		}
	}

}
