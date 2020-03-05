/* 
 * File: Checkerboard.java
 * Author: COMP 151 class
 * Date: February 11, 2016
 * Description: Program to display a checkerboard.  The checkerboard does not resize as the
 * window is resized.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Checkerboard extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
     // Constants
     final int SQUARE_SIZE = 40;
     final int NUM_ROWS = 8;
     final int NUM_COLS = 8;
 
     // Create a gridPane to store the squares of the checkerboard.
     GridPane pane = new GridPane();
     pane.setAlignment(Pos.CENTER); // The grid is centered in the gridpane.  This is the default.
     pane.setPadding(new Insets(0,0,0,0)); // No margin around the nodes in the grid.  0 is the default
     pane.setHgap(0); // No horizontal gap between nodes in the grid.  0 is the default.
     pane.setVgap(0); // No vertical gap between nodes in the grid.  0 is the default.
     
     // Create squares and put them in the gridpane.
     for (int i = 0; i < NUM_ROWS; i++) {
	for (int j = 0; j < NUM_COLS; j++) {
	   Rectangle r = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
	   r.setStroke(Color.BLACK);  // Sets color of the outline of the square.  
	   if ((i + j) % 2 == 0)
	      r.setFill(Color.BLACK);
	   else
	      r.setFill(Color.RED);
	   pane.add(r, i, j);
	}
     }
     
     // Finish up.  Create scene with the pane in it, put scene in stage, and display.
     Scene scene = new Scene(pane);
     primaryStage.setTitle("Checkerboard");
     primaryStage.setScene(scene);
     primaryStage.show();
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) { 
    launch(args);
  }
}
