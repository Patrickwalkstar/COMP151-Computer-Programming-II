/**
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: Unmodified from starter code
 * 
 * Represents a player in this simplified version of the
 * "21" card game.
 */

public class Player {

    /** The name of the player (used for printing purposes). */
    private String name;
    private Hand hand;
   
    public Player (String n) {
        name = n;
        hand = new Hand();
    }
     
    /**
     * Return the value of the player's hand. 
     */
    public int getScore() {
        int v = 0;
        v = hand.getTotalValue();
        return v;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setHand(Hand h) {
		this.hand = h;
	}
	
	public Hand getHand() {
		return this.hand;
	}
}
