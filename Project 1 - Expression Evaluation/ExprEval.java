//Author: Patrick Walker
//Date: 9/22/2017

//This program is used to evaluate an expression of simple arithmetic

//This program reads one entered line at a time
//The program terminates if a whitespace line is entered
//The input expression is expexted to be operands separated by operators
//All tokens of the expression should be separated by white space.
//Multiple operators will result in an error
//Accepted characters are: 1,  2,  3,  4,  5,  6,  7,  8,  9,  0,  . "+", " - "

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExprEval {

 public static void main(String[] args)  {


  Scanner kb = new Scanner(System.in);
  System.out.println("Enter an arithmetic expression to be solved:");

  //Read whole line and split into string array of tokens
  String inputLine = kb.nextLine().trim();
  String [] stringArray = inputLine.split("\\s");

  int firstLineOperand = 0; // first operand (integer) for marking the first calculation

  //Checks to see if the next line is empty. Returns true if the line is empty
  //To make sure the input line is not empty, this check is necessary
  while (inputLine.isEmpty() == false) {

   try {

    //If the first calculation is not performed, read the next line here
     //Since double calls nextLine on startup, this aviods "every other line" action
    if (firstLineOperand == 1) {
     inputLine = kb.nextLine().trim();
     stringArray = inputLine.split("\\s");
    }

    //The program terminates if the input line is empty (including no whitespace characters
    if (stringArray[0].isEmpty() == true) {
     return;
    }

    //The first doulbe value is the first token. 
    //InputMismatch and NumberFormat Exceptions exist to check for correct format
  
    double total= Double.parseDouble(stringArray[0]);

    //Loop through each token of the array
    for (int i = 1; i < stringArray.length;) {

     String tokenati = stringArray[i]; //operator string

     double followingvalue = Double.parseDouble(stringArray[i+1]);  //the next token (double)

     //Checking for validity of operators and calculating results of two operands
     int goodOperand = 0;

     if (tokenati.length() > 1) {
      //IllegalExprException is thrown in case the oprator has multiple characters
      //the character exists as something other than "+" and "-"
      throw new IllegalExprException("Invalid Expression");
     }

     if (tokenati.contains("+") == true) {
      //check the index for addition sign
      total= total + followingvalue;
      goodOperand++;
     }

     if (tokenati.contains("-") == true) {
      //check the index for subtraction sign
      total= total - followingvalue;
      goodOperand++;
     } 

     if (goodOperand == 0) {  //Throw exception 
      throw new IllegalExprException("Invalid Expression");
     }

     i = i + 2; //The next operator token is two indicies away

    }

    System.out.println(total);

   }

   //Catch Blocks for custom exception and common runtime exceptions due to invalid syntax
   catch (IllegalExprException e){
    String message = e.getMessage();
    System.out.println(message);
   }

   catch(java.lang.NumberFormatException e) {
    System.out.println("NumberFormatException: Non-double entered where a double value was expected");

   }

   catch(java.util.InputMismatchException e) {
    System.out.println("InputMismatchException");
   }

   catch(java.lang.ArrayIndexOutOfBoundsException e) {
    System.out.println("ArrayIndexOutOfBoundsException: Operand recieved instead of an operator");

   }

   firstLineOperand = 1;

  }

  kb.close();
  return;

 }
}

