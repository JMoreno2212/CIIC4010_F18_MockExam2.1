public class Card {
	
	private String suit; //Suit of a card, it goes between Diamond, Spade, Club or Heart
	private int rank; // Rank of a card, it goes between 1 till 13 (In order of A, 2, 3,..., 10, J, Q, K)

	/**
	 * A constructor that requires a suit and rank input to initialize a card
	 * @param suit
	 * @param rank
	 */
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * A constructor that uses a different Card to initialize the new card.
	 * @param otherC
	 */
	public Card(Card otherC) {
		this.suit = otherC.suit;
		this.rank = otherC.rank;
	}
	
	
	/**
	 * Override of the method toSting this helps us control how to print a card object.
	 * @return The string "[R,S]" where R is rank and S is suit
	 */
	@Override
	public String toString() {
		return "[" + rank  + "," + suit + "]";
	}

	/**
	 * Override of the equals method to control how card objects are to be compared.
	 * @return comparison 
	 */
	@Override
	public boolean equals(Object c2) {
		if (!(c2 instanceof Card)) {
			throw new RuntimeException("Illegal argument to Card.equals()");
		}
		Card card2 = (Card) c2;
		return ((this.getSuit().equals(card2.getSuit())) && 
				(this.getRank() == card2.getRank()));
	}

	/**
	 * Suit Getter
	 * @return suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Rank Getter
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Suit Setter
	 * @return suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Rank Setter
	 * @return rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Checks if two cards have the same suit
	 * @param card2
	 * @return boolean
	 */
	public boolean sameSuitAs(Card card2) {
		return (this.getSuit().equals(card2.getSuit()));
	}

	/**
	 * Checks if two cards have the same rank
	 * @param card2
	 * @return boolean
	 */
	public boolean sameRankAs(Card card2) {
		return (this.getRank() == card2.getRank());
	}
	
	/**
	 * Returns if a card is an ace
	 * @return boolean
	 */
	public boolean isAnA() { 
		if(this.getRank() == 1) { return true; }
		else return false;
	}
	
	/**
	 * Checks if two cards have the same rank
	 * @param c
	 * @return boolean
	 */
    public boolean isPair(Card c) {
        if(c.getRank() <= 10 && c.getRank() % 2 == 0) {return true;}
        else return false;
    }
    
    /**
	 * Checks if three cards have the same rank
	 * @param c1, c2
	 * @return boolean
	 */
    public boolean isTrio(Card c1, Card c2) {
        if(this.getRank() == c1.getRank() && this.getRank() == c2.getRank()) { return true;}
        else return false;
    }

    /**
	 * Checks if four cards have the same rank
	 * @param c1, c2, c3
	 * @return boolean
	 */
    public boolean isFourTuple(Card c1, Card c2, Card c3) {
    	if(this.getRank() == c1.getRank() && this.getRank() == c2.getRank() && this.getRank() == c3.getRank()) { return true;}
        else return false;
    }
    
   
    /**
     * A method that checks if the target card c1 is a rank
 	* higher than the object card.
 	* @return boolean
     */
    public boolean isConsecutive(Card c1) {
    	return rank + 1 == c1.getRank();
    }
    
    /**
	 * A method that returns true as soon a it has found
	 * that the given card exist in the deck
	 * @param target
	 * @return boolean
	 */
	public boolean cardExistsIn(Card[] deck) {
	    for(int i = 0; i < deck.length; i++) {
	    	if(this.getRank() == deck[i].getRank() && this.getSuit() == deck[i].getSuit()) {
	    		return true;
	    	}
	    }
	    return false; 
	}
	
	/**
	 * A method that returns true as soon as it has found an existing pair
	 * in the deck
	 * @return boolean
	 */
	public boolean pairExists(Card[] deck) {
		for(int i = 0; i < deck.length; i++) {
	    	if(this.getSuit() == deck[i].getSuit()) {
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/**
	 * A method that returns a boolean as soon as it knows if a 
	 * deck is a flush.
	 * Note: When we say flush, we mean that all the cards in
	 * the deck are of the same suit.
	 * @return boolean
	 */
	public boolean isFlush(Card[] deck) {
		if(deck.length == 0) {return true;}
		String targetSuit = deck[0].getSuit();
		for(int i = 1; i < deck.length; i++) {
			if(deck[i].getSuit() != targetSuit) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * A method that returns a boolean as soon as it knows if a 
	 * deck is a consecutive straight.
	 * Note: When we say consecutive straight, we mean that all 
	 * the cards in the deck are in ascending order without
	 * ordering the cards themselves.
	 * @return boolean
	 */
	public boolean isConsecutiveStraight(Card[] deck) {
		if(deck.length == 0) {return true;}
		int targetRank = deck[0].getRank();
		for(int i = 1; i < deck.length; i++) {
			if(!(deck[i].getRank() == targetRank + 1)) {
				return false;
			}
			targetRank +=1;
		}
		return true;
	}
	
	/**
	 * A method that checks if the deck is a consecutive
	 * straight flush with the previously mentioned restrains. 
	 * @return
	 */
	public boolean isConsecutiveStraightFlush(Card[] arr) {
		return isFlush(arr) && isConsecutiveStraight(arr);
	}
}