import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*Simple Blackjack game using JavaFX
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: 10/30/2017
 * 
 * This is a simplified version of a common card game, "21"
 * for Assignment 4. 
 *
 * The players take turns requesting cards, trying to get
 * as close to 21 as possible, but not going over 21. A player
 * may stand (ask for no more cards). Once a player has passed,
 * he or she cannot later ask for another card. When all three
 * players have passed, the game ends.
 *
 * The winner is the player who has come closest to 21 without
 * exceeding it. In the case of a tie, or if everyone goes over
 * 21, no one wins.
 * 
 * Per the assignment, we assume exactly three players. The game 
 * is only played once.
 */

public class Game extends Application {

	// An ArrayList to store the 3 Player objects 
	static ArrayList<Player> players;

	// An ArrayList to store the deck of cards
	static ArrayList<Card> cardDeck;

	public void start(Stage primaryStage) {
		try { 
			Pane pane = new Pane();

			//Initialize deck and deal all player hands
			cardDeck = new ArrayList<Card>();
			initDeck(cardDeck);	Collections.shuffle(cardDeck);

			ArrayList<Player> players = new ArrayList<Player>();
			players.add(new Player("player1"));	players.add(new Player("player2"));
			players.add(new Player("player3"));	Player dealer = new Player("dealer");

			for(int k = 0; k < players.size(); k++) {
				Hand h = new Hand();
				h.addCard(cardDeck.get(0));	cardDeck.remove(0);
				h.addCard(cardDeck.get(0));	cardDeck.remove(0);
				players.get(k).setHand(h);
			}

			Hand dh = new Hand();
			dh.addCard(cardDeck.get(0));	cardDeck.remove(0);
			dh.addCard(cardDeck.get(0));	cardDeck.remove(0);
			dealer.setHand(dh);

			//Displaying hands and labels
			pane.getChildren().addAll(displayHand(players.get(0), 370, 255, 370, 175, 270));
			Label label1 = new Label(players.get(0).getName());	label1.relocate(450, 250);	label1.setRotate(270);
			pane.getChildren().addAll(displayHand(players.get(1), 175, 370, 255, 370, 180));
			Label label2 = new Label(players.get(1).getName());	label2.relocate(230, 470);
			pane.getChildren().addAll(displayHand(players.get(2), 50, 175, 50, 255, 90));
			Label label3 = new Label(players.get(2).getName());	label3.relocate(0, 250);	label3.setRotate(90);
			Image pic7 = new Image(new FileInputStream(dealer.getHand().getCards().get(0).getImagePath()), 70, 100, false, false);
			ImageView cardImage7 = new ImageView();	cardImage7.setImage(pic7);	cardImage7.relocate(175, 40);
			
			
			//
			Image pic8 = new Image(new FileInputStream(dealer.getHand().getCards().get(1).getImagePath()), 70, 100, false, false);
			//
			
			
			ImageView cardImage8 = new ImageView();	cardImage8.setImage(pic8);	cardImage8.relocate(255, 40);
			Label label4 = new Label("Dealer");	label4.relocate(230, 20);
			
			//
			Image pic9 = new Image(new FileInputStream(cardDeck.get(0).getImagePath()), 70, 100, false, false);
			//
			
			
			ImageView deckImage = new ImageView();	deckImage.setImage(pic9);	deckImage.relocate(420, 10);


			////////////START GAME///////////////
			Button startButton = new Button("Play");
			startButton.relocate(10, 10);
			Button closeButton = new Button("End Game");
			closeButton.relocate(10,  40);

			//Close button displays results and effectively ends the game
			closeButton.setOnAction(e -> {
				result(players, dealer, cardDeck);
				primaryStage.close();
				});

			//Start Button initiates player turn stages
			startButton.setOnAction(e-> {
				turn(players.get(2), dealer);
				turn(players.get(1), dealer);
				turn(players.get(0), dealer);
				closeButton.setText("Get Results");
				pane.getChildren().removeAll(startButton, cardImage8);

				//Flip the dealer's second card
				try {
					Image pic10 = new Image(new FileInputStream(dealer.getHand().getCards().get(1).getImagePath()), 70, 100, false, false);
					ImageView dCard = new ImageView(); dCard.setImage(pic10); dCard.relocate(255, 40);
					pane.getChildren().add(dCard);

				} catch (FileNotFoundException e1) {	System.out.println(e1.getMessage());	}
			});

			//Add all items to pane
			pane.getChildren().addAll(cardImage7, cardImage8, deckImage, label1, label2, 
					label3, label4, startButton, closeButton);

			//display stage in scene
			Scene scene = new Scene(pane, 500, 500);	primaryStage.setTitle("Blackjack");
			primaryStage.setScene(scene); 	primaryStage.show(); 
		
		}	catch (FileNotFoundException e) {	System.out.println(e.getMessage());	}
	}


//////////////////////////////////////METHODS/////////////////////////////////////////////////

	//PLAYER TURN METHOD that starts a player's turn stage
	public static void turn(Player player, Player dealer) {

		//Displaying player turn stage, scene and pane
		Stage playerTurnStage = new Stage();
		Pane pane1 = new Pane();
		playerTurnStage.setTitle(player.getName() + "'s turn");
		Scene scene1 = new Scene(pane1, 500, 500);
		playerTurnStage.setScene(scene1);
		playerTurnStage.show();

		try {
			//Display dealer and players hands
			Image pic22 = new Image(new FileInputStream(dealer.getHand().getCards().get(0).getImagePath()), 70, 100, false, false);
			ImageView cardImage22 = new ImageView();	cardImage22.setImage(pic22);	cardImage22.relocate(175, 40);
			Image pic23 = new Image(new FileInputStream("images/Red.jpg"), 70, 100, false, false);
			ImageView cardImage23 = new ImageView();	cardImage23.setImage(pic23);	cardImage23.relocate(255, 40);
			Label label23 = new Label("Dealer");	
			label23.relocate(230, 20);
			pane1.getChildren().addAll(displayHand(player, 10, 350, 90, 350, 0));
			Label label20 = new Label(player.getName());	
			label20.relocate(230, 470);
			Label labelValue = new Label(Integer.toString(player.getScore()));	
			labelValue.relocate(400, 200);
			Label scoreLabel = new Label(player.getName() + "'s Score:");		
			scoreLabel.relocate(300, 200);

			//Stand Button used to end the player's turn
			Button standButton = new Button("Stand");
			standButton.relocate(50, 200);
			standButton.setOnAction(k -> {
				playerTurnStage.close();
			});


			//HIT BUTTON, Add card, update total
			Button hitButton = new Button("Hit");
			hitButton.relocate(130, 200);
			hitButton.setOnAction(e -> {

				//Drawing card on hit button
				player.getHand().addCard(cardDeck.get(0));
				cardDeck.remove(0);

				//Adding new card images as they are drawn
				ArrayList<Card> playerCards = new ArrayList<Card>();
				playerCards = player.getHand().getCards();

				try {
					Image pic = new Image(new FileInputStream(playerCards.get(playerCards.size() - 1).getImagePath()), 70, 100, false, false);
					ArrayList<ImageView> newCardImage = new ArrayList<ImageView>();
					newCardImage.add(new ImageView(pic));
					newCardImage.get(newCardImage.size() - 1).relocate(90 + 80 * (playerCards.size() - 2), 350);
					pane1.getChildren().addAll(newCardImage);

				} catch(FileNotFoundException g) { g.getMessage();	}

				//Change ace value if score is over 21
				for (int i = 0; i < playerCards.size(); i++) {
					if (playerCards.get(i).getValue() == 11 && player.getScore() > 21) {
						playerCards.get(i).setValue(1);
						player.getHand().updateTotalValue();
					}}

				//Force end turn on bust or 21
				if (player.getScore() >= 21) {
					pane1.getChildren().remove(hitButton);
					standButton.setText("Turn Over; Continue");
					standButton.setPrefSize(200,  40);
					standButton.relocate(50, 190);
				}

				//Setting score label text to the player's updated score
				labelValue.setText(Integer.toString(player.getScore()));
			});

			//Chicken Dinner if dealt blackjack
			if (player.getScore() == 21) {
				pane1.getChildren().remove(hitButton);
				standButton.setText("Winner Winner Chicken Dinner");
				standButton.setPrefSize(300, 40);
				standButton.relocate(50,  190);	//Hit button is still visible behind for some reason
			}

			//If dealt two aces, change one to a value of 1
			if(player.getScore() == 22) {
				player.getHand().getCards().get(0).setValue(1);
				player.getHand().updateTotalValue();
			}

			//Add all items to pane and display player turn stage
			pane1.getChildren().addAll(hitButton, standButton, label23, cardImage23, cardImage22, label20, labelValue, scoreLabel);

		}	catch (FileNotFoundException f) {	System.out.println(f.getMessage());	}
	}


	//RESULT METHOD: shows the results of the game in a new stage by calling the dealer logic method and comparing the scores
	public static void result(ArrayList<Player> player, Player dealer, ArrayList<Card> cardDeck) {
		Stage resultStage = new Stage();
		Pane pane2 = new Pane();
		resultStage.setTitle("Blackjack Results");
		Scene scene2 = new Scene(pane2, 500, 500);
		resultStage.setScene(scene2);
		resultStage.show();

		String r = "No result";

		int ds = dealerLogic(dealer, cardDeck);

		for (int i = 0; i < player.size(); i++) {

			if (ds > player.get(i).getScore() && ds <= 21) { r = "You Lose C1";	}

			if (ds > 21 && player.get(i).getScore() <= 21) {	r = "You WIN C2";	}

			if (player.get(i).getScore() > ds && player.get(i).getScore() <= 21) {	r = "You WIN C3";	}

			if (player.get(i).getScore() > 21 && ds > 21) {	r = "Tie C4";	}

			if (player.get(i).getScore() > 21 && ds <= 21) {	r = "You LOSE C5";	}

			Label value = new Label(player.get(i).getName() + "'s score: " + Integer.toString(player.get(i).getScore())); value.relocate(10, 50 + (i*50));
			Label result = new Label(r);		result.relocate(200, 50 + (i*50));

			pane2.getChildren().addAll(value, result);
		}

		Label dealerScore = new Label("Dealer's score: " + Integer.toString(ds)); dealerScore.relocate(10, 10);
		pane2.getChildren().add(dealerScore);
	}



	//DEALER LOGIC METHOD that plays out the dealer's turn automatically 
	public static int dealerLogic(Player dealer, ArrayList<Card> cardDeck) {

		//Getting the dealer's cards
		ArrayList<Card> dealerCards = new ArrayList<Card>();
		dealerCards = dealer.getHand().getCards();
		
		//draw card if under 17
		while (dealer.getScore() < 17) {
			dealer.getHand().addCard(cardDeck.get(0));
			dealer.getHand().updateTotalValue();
		}
		
		//Check for aces and change to value of 1 if score over 21
		for (int i = 0; i < dealer.getHand().getCards().size(); i++) {
			if (dealerCards.get(i).getName().contains("A") && dealer.getScore() > 21) {
				dealerCards.get(i).setValue(1);
				dealer.getHand().updateTotalValue();
			}
		}

		return dealer.getScore();

	}



	//DISPLAY HAND METHOD that displays a player's cards at the specified locations and rotation
	public static ImageView[] displayHand(Player p, double x1, double y1, double x2, double y2, double r) {
		Image pic1;
		try {
			pic1 = new Image(new FileInputStream(p.getHand().getCards().get(0).getImagePath()), 70, 100, false, false);

			ImageView [] cardImages = new ImageView[2];

			ImageView cardImage1 = new ImageView();
			cardImage1.setImage(pic1);
			cardImage1.relocate(x1, y1);
			cardImage1.setRotate(r);
			cardImages[0] = cardImage1;

			Image pic2 = new Image(new FileInputStream(p.getHand().getCards().get(1).getImagePath()), 70, 100, false, false);
			ImageView cardImage2 = new ImageView();
			cardImage2.setImage(pic2);
			cardImage2.relocate(x2, y2);
			cardImage2.setRotate(r);
			cardImages[1] = cardImage2;

			return cardImages;

		} catch (FileNotFoundException e) {	e.getMessage();	}
		return null;
	}



	//INITIALIZE DECK METHOD that initializes the deck with card names, values, and images
	public static void initDeck(ArrayList<Card> d) {

		String[] suits = new String[] {"C", "D", "H", "S"};
		String[] faces = new String[] {"J", "Q", "K", "A"};

		for (String s: suits) {           
			for(int i = 2; i < 11; i++) {
				// Create and add a new card for each of the numbered cards
				String name = i + s; 
				String imagePath = "images/" + name + ".png";
				Card c = new Card(name, imagePath, i);
				d.add(c);
			}
		} 

		for (String s:suits) {           
			for(String f:faces) {
				// Create and add a new card for each of the face cards
				String name = f + s; 
				String imagePath = "images/" + name + ".png";

				if( f.equals("A") )
					d.add(new Card(name, imagePath, 11));
				else	
					d.add(new Card(name, imagePath, 10));
			}
		} 
	}


	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}