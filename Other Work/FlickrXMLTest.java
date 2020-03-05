
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FlickrXMLTest extends Application {
	private static final int imageWidth = 640, imageHeight = 640;	// medium 640 on flickr
	private static final String API_KEY="7b7ed01e054cb2608f8d5f510fc444e7";

	private Stage primaryStage;
    private BorderPane rootLayout;
	private Pane imagePane;						// drawing component
	private TextField queryField;				// GUI text field for query
	private ArrayList<Image> images;				// loaded images, using Java type
	private int curr;							// index of currently-displayed image
	private String sort = "relevance";			// how to sort when search
	
	public FlickrXMLTest() { 
		images = new ArrayList<>();
		imagePane = new Pane();
		curr = 0;
	}
	
	private void search() {
		String query = this.queryField.getText();
		
		try {
			fetchImages(query);
		}
		catch (Exception e) {
			System.out.println("Error occured when qureying for images");
		}
		
		// Start on the first returned image
		curr = 0;		
		this.updateImage();
	}
	
	/**
	 * Performs a Flickr search for a query 
	 */
	private void fetchImages(String q) throws Exception {
		
		// Build the REST query as specified in the Flickr API
		String numResults = "10";
		
		String request = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + API_KEY +
				"&text=" + URLEncoder.encode(q,"UTF-8") + "&per_page=" + numResults;

		// Get the XML document as a string
		BufferedReader in = new BufferedReader(new InputStreamReader(new URL(request).openStream()));
		String xml = collectString(in);

		// Parse it, following Oracle example.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource source = new InputSource();
		source.setCharacterStream(new StringReader(xml));
		Document doc = builder.parse(source);

		// Get a list of the photo elements, loop over them and use our attribute method to 
		// read the attribute values that are needed to fetch a photo by URL
		NodeList photos = doc.getElementsByTagName("photo");
		
		for (int i = 0; i < photos.getLength(); i++) {
			Node n = photos.item(i);
			try {
				// Build the image URL as specified in the Flickr API
				String url = "http://farm" + attribute(n, "farm") + ".staticflickr.com/" + 
						attribute(n, "server") + "/" + attribute(n, "id") + "_" + 
						attribute(n, "secret") + "_z.jpg";
				images.add(new Image(url, imageWidth, 0, false, false));
			}
			catch (Exception e) {
				System.out.println("couldn't load image");
			}
		}
	}
	
	/**
	 * see activity description: what does this method do? 
	 */
	private static String collectString(BufferedReader in) throws Exception {
		String str = ""; 
		String line = "";
		
		while ((line = in.readLine()) != null) {
			str += line + "\n";
		}
		in.close();	
		return str;
	}
	
	/**
	 * Returns the value for the attribute of the given name in the node, "" if not found.
	 */
	private static String attribute(Node n, String name) {
		NamedNodeMap atts = n.getAttributes();
		for (int i = 0; i < atts.getLength(); i++) {
			Node att = atts.item(i);
			if (att.getNodeName() == name) {
				return att.getNodeValue();
			}
		}
		return "";
	}
	
	private void updateImage() {
        ImageView main = new ImageView(images.get(curr));
        imagePane.getChildren().clear();
        imagePane.getChildren().add(main);
	}
	
	private void navigateLeft() {
		if( curr == 0 ) {
			curr = images.size();
		}
		
		if (images.size() > 0) {
			curr = (curr - 1) % images.size();
			this.updateImage();
		}		
	}
	
	private void navigateRight() { 
		if (images.size() > 0) {
			curr = (curr + 1) % images.size();
			this.updateImage();
		}
	}
	
	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        rootLayout = new BorderPane();
        queryField = new TextField();
        
        Button search = new Button("Search");
        search.setOnAction( e -> {search(); } );

        Label spaceLabel = new Label("     ");
        spaceLabel.setPadding(new Insets(0, 20, 0, 20));
        
        Button leftArrow = new Button("Previous");
        leftArrow.setOnAction( e -> {navigateLeft(); } );
        
        Button rightArrow = new Button("Next");
        rightArrow.setOnAction( e -> {navigateRight(); } );
                
        Label currLabel = new Label();
        currLabel.setPadding(new Insets(0, 10, 0, 10));
        
        HBox controlPane = new HBox(queryField, search, spaceLabel, leftArrow, currLabel, rightArrow);
        controlPane.setPadding(new Insets(15, 12, 15, 12));
        controlPane.setSpacing(10);
        
        String url = "http://farm4.staticflickr.com/3109/2704173082_b09fd79156_z.jpg";
        ImageView main = new ImageView(new Image(url, imageWidth, 0, false, false));

        imagePane.getChildren().add(main);
        rootLayout.setTop(controlPane);
        rootLayout.setCenter(imagePane);

    		//Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Flickr Browser");
        initRootLayout();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}