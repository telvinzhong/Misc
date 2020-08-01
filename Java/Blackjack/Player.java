import java.util.*;

public class Player extends InvalidDeckException {	
	private int money;
	private int bet;
	private ArrayList <Card> hand;
	Scanner keyboard = new Scanner(System.in);
	
	public Player() {
		money = 1000;
        hand = new ArrayList <Card> (10);
	}
	
	public int getMoney() {
		return this.money;
	}
    
    public int getBet(){
		return this.bet;
    }
    
	public void win() {
		money += bet;
		bet = 0;
    }
    
    // Blackjacks are worth 1.5.
    public void bigWin() {
		money += bet * 1.5;
		bet = 0;
	}

	public void loss() {
		money -= bet;
		bet = 0;
	}
	
	public void resetmoney() {
		money = 0;
	}
	
	public void setBet(int newBet) {
		bet = newBet;
	}
	
	public int getPoints() {
        int num = 0;
		for (Card i: hand) {
            num += i.getPointValue();
        }

        return num;
	}
        
    // Needs to invoke deck method to get the right card.
	public void drawCard(Card card) {
		hand.add(card);
	}
	
	public void printHand() {
        
        for (Card i : hand) {
            System.out.print(i.toString());
        }
	}
		
	public boolean checkBlackjack() {
		return this.getPoints() == 21;
	}

	public void clearHand() {
		hand.clear();
	}
		
    // Announce player one/two turn in main.

	

    public static void main(String[] args) {
        Player telvin = new Player();
        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            Card temp = deck.getCard();
            telvin.drawCard(temp);
        }

        telvin.printHand();
		System.out.println(telvin.getPoints());

    }
}
