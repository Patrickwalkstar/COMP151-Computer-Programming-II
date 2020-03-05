import java.util.Scanner;

public class TempConvertDemo extends TempConvert{
public static void main (String [] args) { 
   Scanner     scanner = new Scanner(System.in);
   TempConvert tc      = new TempConvert();
   System.out.println("I am the converter.");
   System.out.print("Input temp?");
   double  itemp = scanner.nextDouble();
   System.out.print("Input units?");
   String  iunit = scanner.next();
   System.out.print("Output units?");
   String  ounit = scanner.next();

   double otemp = tc.convertTemp(itemp, iunit, ounit);
   System.out.println("The answer is " + otemp);
 } // end main() method
} // end class
