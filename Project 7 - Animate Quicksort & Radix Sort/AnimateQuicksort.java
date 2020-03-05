import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Name: AnimateQuicksort
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: 12-20-2017
 * 
 * Description: Animates the first data partition of a quicksort algorithm
 * 
 */
public class AnimateQuicksort extends Application {

	private int pivot;
	private int pivotIndex;
	private int low;
	private int high;

		/*
		 * Uses JavaFX to animate the partition
		 */
		public void start(Stage primaryStage){
			
			//Create ArrayList of random integers from 1 to 1000
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			double rando;
			int num;
			
			for (int i = 0; i < 20; i++) {
			rando = Math.random();
			num = (int) (rando*999);
			numbers.add(num);
			}
			
			//Formatting GridPane
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setHgap(20);
			pane.setVgap(50);
			pane.setPadding(new Insets(50, 50, 50, 50));
			
			//Setting up the initial display
			for (int j = 0; j < numbers.size(); j++) {
				Label label = new Label(numbers.get(j).toString());
				pane.add(label,j,2);
			}
			
			Label pivotLabel = new Label("Pivot");
			Label lowLabel = new Label("Low");
			Label highLabel = new Label("High");
			pane.add(pivotLabel, 0, 1);
			pane.add(lowLabel, 1, 1);
			pane.add(highLabel, 19, 1);
		
			Button stepButton = new Button("Step");
			pane.add(stepButton, 0, 0);
			
			//PARTITION PROCESS
			pivotIndex = 0;
		    pivot = numbers.get(pivotIndex); // Choose the first element as the pivot
		    low = pivotIndex + 1; // Index for forward search
		    high = 19; // Index for backward search
				
		    	
			      // Search forward from left
		    stepButton.setOnAction(e -> {
		    	
			    while (high > low) {
			    	
		    	while (low <= high && numbers.get(low) <= pivot) {
		        low++;
		        GridPane.setConstraints(lowLabel, low, 1);
		    	}
		   
			      // Search backward from right
			      while (low <= high && numbers.get(high) > pivot) {
					        high++;
					        GridPane.setConstraints(highLabel, high, 1);
			      }
		    
			      if (high > low) {
				        int temp = numbers.get(high);
				        numbers.set(high, numbers.get(low));
				        numbers.set(low, temp);
		      }  
			    }
			    
			    while (high > 0 && numbers.get(high) >= pivot) {
			        high++;
			        GridPane.setConstraints(highLabel, high, 1);
	      }
	      

		    // Swap pivot with list[high]
		    if (pivot > numbers.get(high)) {
		    		  numbers.set(0, numbers.get(high));
				      numbers.set(high, pivot);
		     
		    }
			    
			    
		    });


				for (int j = 0; j < numbers.size(); j++) {
					Label label = new Label(numbers.get(j).toString());
					pane.add(label,j,3);
				}
				
		
				// Create scene with the pane in it, put scene in stage, and display.
				Scene scene = new Scene(pane, 1200, 250);
				primaryStage.setTitle("Quick Sort Partition");
				primaryStage.setScene(scene);
				primaryStage.show();
				
		}
	  
		
	public static void main(String[] args) {
		launch(args);
	}

}
