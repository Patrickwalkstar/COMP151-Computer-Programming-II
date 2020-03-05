import java.util.ArrayList;

/**
 * Represents a hand of cards in this simplified version of Blackjack.
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: 10/30/2017
 * 
 * Added getCards method to starter code
 */


public class Hand {
	private ArrayList<Card> cards;
	private int totalValue;

	public Hand() {
		cards = new ArrayList<Card>();
		totalValue = 0;
	}

	 // Add a card to the hand
	public void addCard(Card c) {
		cards.add(c);
		this.totalValue = updateTotalValue();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public int updateTotalValue() {
		int v = 0;
		
		for(Card c:cards) {
			v += c.getValue();
		}
		totalValue = v;
		return v;
	}



	public int getTotalValue() {
		return totalValue;
	}

}