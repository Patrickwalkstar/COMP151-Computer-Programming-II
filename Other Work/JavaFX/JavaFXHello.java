import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXHello extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
	    	// Make stuff to display to the user
	    	Text t2 = new Text();
	    	t2.setFont(new Font(20));
	    	t2.setWrappingWidth(200);
	
	    	t2.setX(150);
	    	t2.setY(500);
	
	    	t2.setText("Patrick Walker");
    	
	    
	    
	    			
/*    	
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
*/	    


        // Create a pane to hold the Nodes 
        Pane pane = new Pane();
        pane.getChildren().add(t2);
   
        Circle c = new Circle();
		c.setStroke(Color.BLACK);
		c.setFill(Color.AZURE);
		c.centerXProperty().bind(pane.widthProperty().divide(2));
		c.centerYProperty().bind(pane.heightProperty().divide(2));
        
        pane.getChildren().add(c);
        // Create a Scene
        Scene scene = new Scene(pane, 500, 500);
        
        // Make changes to the stage
        primaryStage.setTitle("Patrick Walker"); // Set the stage title
        
     	// Place the scene in the stage
        primaryStage.setScene(scene); 
        
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