/* Name: COMP 151 Lecture 9
 * Date: October 5, 2017
 * Description: Basic student profile program for practicing 
 *      Controls and JavaFX.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ToreroProfile extends Application {

	Stage stageRef;
    ArrayList<Torero> allProfiles;
    int sceneWidth = 400;
    int sceneHeight = 300;
    

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stageRef = stage;
        allProfiles = new ArrayList<Torero>();
  
        addProfileScene();
        stage.show();
      }
    
    
    
    //Decscription: Displays the profile of the Torero passed in.

    private void previewProfile(Torero t) {
        // TODO Make this preview look nice
        // Consider using another layout
        // or stick with BorderPane and adjust the spacing

        BorderPane borders = new BorderPane();
        
        ImageView profilePic = new ImageView();
        
        
        // TODO Experiment with some options for making the header look nice
        
        borders.setTop(new Text("New Torero Profile"));
        borders.setLeft(profilePic);
       
        // TODO Experiment with some options for making the full profile look nice
        
        // Format the fields from the new Torero object and display it in a Label
        String fullText = "Name: " + t.getStudentName() + "\n";
        fullText += "Class: " + t.getGradClass() + "\n";
        fullText += "Major: " + t.getMajor() + "\n";
 
        
        if (t.getLivesOnCampus())
            fullText += "Residence: on campus \n";
        else
            fullText += "Residence: off campus \n";
        
        fullText += "Hometown: " + t.getHometown() + "\n";

        
        Label newProfile = new Label(fullText);
        borders.setCenter(newProfile);
        
        Button addProfileButton = new Button("Add a profile");
        addProfileButton.setOnAction( e -> {addProfileScene(); } );
        
        Button viewAllProfilesButton = new Button("View all profiles");
        viewAllProfilesButton.setOnAction( e -> {viewAllScene(); } );
        
        HBox bottomButtons = new HBox(new Button("Edit profile"), addProfileButton, viewAllProfilesButton);
        bottomButtons.setPadding(new Insets(15, 12, 15, 12));
        bottomButtons.setSpacing(10);
        borders.setBottom(bottomButtons);
   		
        Scene scene = new Scene(borders, sceneWidth, sceneHeight);
		stageRef.setScene(scene);
	}

    // Composes a form of Controls so that the user can enter a new profile
    private void addProfileScene() {
        BorderPane addStudent = new BorderPane();
        
        // TODO: update the GridPane properties so that this looks nice
        GridPane newProfileForm = new GridPane();
        
        // TODO delete the line that sets the gridlines to visible when
        // you're happy with how the gridPane looks
        
     
        newProfileForm.add(new Text("Name"),0,0);
        TextField name = new TextField();
        newProfileForm.add(name,1,0);
        
        newProfileForm.add(new Text("Class"),0,1);
        TextField classfield = new TextField();
        newProfileForm.add(classfield,1,1);
 
       
        newProfileForm.add(new Text("Major"),0,2);
        TextField majorfield = new TextField();
        newProfileForm.add(majorfield,1,2);
        
        newProfileForm.add(new Text("Lives on campus"),0,3);
        CheckBox livesoncampus = new CheckBox();
        newProfileForm.add(livesoncampus,1,3);
        
        
        newProfileForm.add(new Text("Hometown"),0,4);
        TextField hometownfield = new TextField();
        newProfileForm.add(hometownfield,1,4);
        
        
        Button submitButton = new Button("Submit profile");
        submitButton.setOnAction( e -> {
        	
        int classValue = Integer.parseInt(classfield.getText());
        
            Torero submittedProfile = new Torero(name.getText(), classValue, majorfield.getText(), 
            		hometownfield.getText(),livesoncampus.isSelected());
            
            submitNewProfile(submittedProfile);
            previewProfile(submittedProfile);
        } );
        
        
        addStudent.setTop(new Text("Create a new student profile"));
        addStudent.setCenter(newProfileForm);
        addStudent.setBottom(submitButton);
        
        Scene scene = new Scene(addStudent, sceneWidth, sceneHeight);
        stageRef.setScene(scene);
    }
    
    private void viewAllScene() {
        // TODO complete this method
       ObservableList <Torero> names = FXCollections.observableArrayList(allProfiles);
        // 1. Use a ListView to show all of the existing student profiles
        //
        // 2. Allow the user to select a student and edit the profile
        
        //
        // Hint: the ArrayList allProfiles has a Torero instance for each profile that
        // was added
        
        for (Torero t: allProfiles) {
            System.out.println(t.getStudentName());
        }
    }

	private void submitNewProfile(Torero t) {
        allProfiles.add(t);
        System.out.println("A new profile was submitted");
    }
}
