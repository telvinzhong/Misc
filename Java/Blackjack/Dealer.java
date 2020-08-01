import java.util.*;

public class Dealer extends Player {
    
    private ArrayList <Card> hand;
      
    public Dealer() {
        super();
    }

    // Automated, so take the deck as argument instead of a single card.
    public void dealerPlay(Deck deck) {
		while (this.getPoints() <= 16) {
			System.out.println("Dealer has " + this.getPoints() + " and hits.");
			this.drawCard(deck.getCard());
        } 

		if (this.getPoints() > 21) {
			System.out.println("Dealer busts.");
		} else {
			System.out.println("Dealer stands.");
        }

        this.printHand();
    }
    
    // Error: Fix later
    public void printDealerHand() {
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0) {
                System.out.println("Facedown");
            } else {
                System.out.print(hand.get(i));
            }
        }
    }

}
