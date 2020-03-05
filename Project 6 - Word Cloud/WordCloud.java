import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.control.Label;


/*
 * Title: WordCloud
 * Authors: Devon Stedronsky & Patrick Lee Walker
 * Date Last Modified: 11/28/2017
 * 
 * Description:
 * Creates a word cloud from a user specified text file where displayed words are sized based on their frequency
 * Assume words are separated by one or more spaces
 * Remove all punctuation besides apostrophes
 * Do not include stop words (stored in stop-words.txt)
 */

public  class WordCloud extends Application {

 private static TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();

 /*
  * Read in all the words from the specified file and store them in the TreeMap
  */
 public static void getWordsFromFile(File f) {
  try {
   //Opening scanner for the file
   Scanner wordScan = new Scanner(f);

   //Scanning each word and adding it to the map
   while(wordScan.hasNext()) {
    String word = wordScan.next().replaceAll("[,_\".!?:;)(}{]", " ").toLowerCase().trim();
    int count = 0;

    //If the word key is already in the map increment the count from the current value
    if (wordMap.containsKey(word)) {
     count = wordMap.get(word);
    }
    wordMap.put(word, count + 1);
   }
   wordScan.close(); 

   //Scan stop words file and remove all stop words from the map
   File stopWordsFile = new File("src/stop-words.txt");
   Scanner stopScan = new Scanner(stopWordsFile);
   while (stopScan.hasNext()) {
    String stopWord = stopScan.next().toLowerCase();
    wordMap.remove(stopWord);
   }
   stopScan.close();
  } 

  catch (Exception e) {
   e.getMessage();
  }
 }


 /*
  * Uses JavaFX to display the word cloud
  */
 public void start(Stage primaryStage){
  
  //Prompting user for file name
  try {
   System.out.println("Enter filename you wish to make a word cloud of:");
   Scanner fileNameScan = new Scanner(System.in);
   String fileName = fileNameScan.nextLine();
   File f = new File(fileName);
   
   while (f.exists() == false) {
    System.out.println("File does not exist enter a valid file name:");
    fileName = fileNameScan.nextLine();
    f = new File(fileName);
   }
   
   fileNameScan.close();
   getWordsFromFile(f);
  } 
  catch(Exception e) {
   System.out.println(e.getMessage());
  }
  

  //Formatting GridPane
  GridPane pane = new GridPane();
  pane.setAlignment(Pos.CENTER);
  pane.setHgap(5);
  pane.setVgap(5);
  pane.setPadding(new Insets(7, 7, 7, 7));

  //Initializing variables
  int countCol = 0; int countRow = 1;
  int originalSize = wordMap.size();

  //Loop adding words to the GridPane
  while(wordMap.isEmpty() != true) {
   String current =  wordMap.lastKey();
   Label label = new Label(current);

   //Changing font based on word instances
   int value = wordMap.get(current);
   label.setFont(new Font(12 + 250*value/originalSize));
   
   //Create a random color for each word,  change the color for each word
   Random rand = new Random();
   int r = rand.nextInt(255);
   int g = rand.nextInt(255);
   int b = rand.nextInt(255);
   Color randomColor = Color.rgb(r, g, b);
  
   label.setTextFill(randomColor);

   //Tracking GridPane row/column coordinates
   pane.getChildren().add(label);
   GridPane.setConstraints(label, countCol, countRow - 1);
   if (countRow < java.lang.Math.sqrt(originalSize)) {
    countRow++;
   } else {
    countRow = 1;
    countCol++;
   }

   wordMap.remove(current); //Remove the word to continue iterating through wordMap
  }

  // Create scene with the pane in it, put scene in stage, and display.
  Scene scene = new Scene(pane, 1000, 500);
  primaryStage.setTitle("Cloud");
  primaryStage.setScene(scene);
  primaryStage.show();
 }

 //Main Method for IDE with limited FX support
 public static void main(String[] args) {
  launch(args);
 }
}
