import java.io.*;
import java.util.*;
public class TextFileExample{
  public static final String FILE_NAME = "test.txt";
  public static void main (String [] args){
   writeTextFile();
    readTextFile();
  }
  public static void readTextFile(){
    Scanner f;
    FileReader fr;
    String input;
    try{
      fr = new FileReader(FILE_NAME);
      f = new Scanner(fr);
      while(f.hasNext()){
        input = f.nextLine();
        System.out.println(input);
      }
      f.close();
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
  public static void writeTextFile(){
    String input;
    Scanner kb;
    PrintWriter pw;
    try{
      
      pw = new PrintWriter(FILE_NAME);
      kb = new Scanner(System.in);
      System.out.println("Type something, just enter to end!");

      do{
              input = kb.nextLine();
      if(input.equals("") == false);
      pw.println(input);
      }while (input.equals("")==false);
      pw.close();
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }finally{
      
    }
  }
}