public class Card {
    /**
     * This class represents a standard playing card.
     */
	private char suit;
	private int value;

	public Card() {
		suit = ' ';
		value = 0;
	}

	public Card(char s, int v) throws InvalidCardException {
		if (v < 1 || v > 13) {
			throw new InvalidCardException();
		} else {
			
			this.value = v;
		}
		if (s != 'D' && s != 'S' && s != 'H' && s != 'C') {
			throw new InvalidCardException();
		} else {
			this.suit = s;
		}
    }
    
    public Card(Card other) {
        this.suit = other.getSuit();
        this.value = other.getValue();
    }

    // Getters 

	public char getSuit() {
		return this.suit;
    }

    public int getValue() {
		
		return this.value;
	}

	public int getPointValue() {
		if (this.value <= 10) {
		return this.value;
		} else {
			return 10;
		}
	}
    
	public String toString() {
		return String.format("%s of %s\n", this.getValueName(), this.getSuitName());
	}

	public String getSuitName() {
        String a;

		if (this.suit == 'H') {

			a = "Hearts";

		}
		else if (this.suit == 'S') {

			a = "Spades";

		}
		else if (this.suit == 'C') {

			a = "Clubs";

		}
		else if (this.suit == 'D') {

			a = "Diamonds";

		} else {

			a = "Unknown";
		}
		
		return a;

    }
    
	public String getValueName(){

		String name = "Unknown";

		if (this.value == 1) {		
			name = "Ace";
		}
		else if (this.value == 2) {
			name = "Two";
		}
		else if (this.value == 3) {
			name = "Three";
		}
		else if (this.value == 4) {
			name = "Four";
		}
		else if (this.value == 5) {
			name = "Five";
		}
		else if (this.value == 6) {
			name = "Six";
		}
		else if (this.value == 7) {
			name = "Seven";
		}
		else if (this.value == 8) {
			name = "Eight";
		}
		else if (this.value == 9) {

			name = "Nine";
		}
		else if (this.value == 10) {

			name = "Ten";
		}
		else if (this.value == 11) {

			name = "Jack";
		}
		else if (this.value == 12) {

			name = "Queen";
		}
		else if (this.value == 13) {

			name = "King";

		} 
		return name;

	}
	
	public boolean compareSuit(Card card){
		
		return this.suit == card.getSuit();
		
	}
	
	public boolean compareValue(Card card){
		
		return this.value == card.getValue();
	}
	
	public boolean compareTo(Card card){
		
		return this.suit == card.getSuit() && this.value == card.getValue();
	}

}