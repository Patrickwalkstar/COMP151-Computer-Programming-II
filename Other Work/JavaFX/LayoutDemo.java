import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
	    // Make stuff to display to the user
   
   		Button[] buttons = new Button[10];

   		// Experiment #1: VBox layout
   		VBox vbox = new VBox();
   		
   		for (int i = 0; i < buttons.length; i++) {
   			buttons[i] = new Button(Integer.toString(i));
   			//buttons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
   			buttons[i].setMaxWidth(Double.MAX_VALUE);
   			buttons[i].setMaxHeight(Double.MAX_VALUE);
   			
   			vbox.getChildren().add(buttons[i]);
   		}
   		
   		BorderPane borderpane = new BorderPane();
   		borderpane.setTop(buttons[0]);
   		borderpane.setBottom(buttons[1]);
   		borderpane.setLeft(buttons[2]);
   		borderpane.setRight(buttons[3]);
   		borderpane.setCenter(buttons[4]);
   		Scene scene1 = new Scene(borderpane, 200, 200);
   		// Choose a layout to experiment with
   		
   		/* 
   		 * TilePane
   		 * GridPane
   		 * BorderPane
   		 * HBox
   		 * FlowPane
   		 * StackPane
   		 * AnchorPane
   		 */
  	    		
   		
   		Scene scene = new Scene(vbox, 500, 500);
    		
        // Make changes to the stage
        primaryStage.setTitle("Layout demo"); // Set the stage title
              
     	// Place the scene in the stage
        primaryStage.setScene(scene1); 
        
        // Display the stage	
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
