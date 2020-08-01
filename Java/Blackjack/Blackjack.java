import java.util.Scanner;


public class Blackjack extends Exception {
	/**
     * This class allows users to play Blackjack.
     */
	Scanner keyboard = new Scanner(System.in);
    Player one;
    Player two;
    Deck deck;
    Dealer dealer;

    public void beginGame() throws InvalidDeckException {

        System.out.println("Welcome to Blackjack!");
		System.out.println("");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println("	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("	-The players cards are added up for their total.");
		System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends."); 
		System.out.println("	-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println("");
        System.out.println("");
        
        this.deck = new Deck();
        this.one = new Player();
        this.two = new Player();
        this.dealer = new Dealer();

    }

    public void placeBets() {
        System.out.printf("Player one, you have %d available. Place your bet:\n", one.getMoney());
        int bet = keyboard.nextInt();
        while (bet > one.getMoney() || bet < 0) {
            System.out.println("Please enter a valid number.");
        }
        one.setBet(bet);
        
        System.out.printf("Player two, you have %d available. Place your bet:\n", two.getMoney());
        int bet1 = keyboard.nextInt();
        while (bet1 > two.getMoney() || bet1 < 0) {
            System.out.println("Please enter a valid number.");
        }
        two.setBet(bet1);
    }

    public void dealCards() {
        one.drawCard(deck.getCard());
        one.drawCard(deck.getCard());

        two.drawCard(deck.getCard());
        two.drawCard(deck.getCard());

        dealer.drawCard(deck.getCard());
        dealer.drawCard(deck.getCard());
    }

    public boolean checkBlackjack() {
        // Check if one or more players have blackjack.
        boolean a = dealer.checkBlackjack();
        boolean b = one.checkBlackjack();
        boolean c = two.checkBlackjack();

        if (a || b || c) {
            if (a && b && c) {
                System.out.println("Everyone got a blackjack! What are the odds?");
                one.bigWin();
                two.bigWin();
                return true;
            }

            if (a && b) {
                System.out.println("Dealer and player one have blackjacks!!");
                one.bigWin();
                return true;
            }

            if (a && c) {
                System.out.println("Dealer and player two have blackjacks!!");
                two.bigWin();
                return true;
            }

            if (b && c) {
                System.out.println("Player one and player two have blackjacks!!");
                one.bigWin();
                two.bigWin();
                return true;   
            }
            if (a) {
                System.out.println("Dealer has a blackjack!!");
                one.loss();
                two.loss();
                return true;
            }

            if (b) {
                System.out.println("Player one has a blackjack!!");
                one.bigWin();
                two.loss();
                return true;
            }
            if (c) {
                System.out.println("Player two has a blackjack!!");
                one.loss();
                two.bigWin();
                return true;
            }

        }
        return false;
    }

    public void printBoard() {
        System.out.println("\nDealer's cards:");
        // Error: Switch to printDealerHand after debugged.
        dealer.printHand();
        System.out.println("\nPlayer One's cards:");
        one.printHand();
        System.out.println("\nPlayer Two's cards:");
        two.printHand();
    }

    public void collect(Player x) {

        if (x.getBet() > 0 ) {
            if (x.getPoints() > 21) {
                System.out.println("Player has busted.");
                x.loss();

            } else if (x.getPoints() == dealer.getPoints() ) {
                System.out.println("Player has pushed.");

            } else if (x.getPoints() < dealer.getPoints() && dealer.getPoints() <= 21 ) {
                System.out.println("Player has lost");
               x.loss();
            } else if (x.getPoints() == 21) {
                System.out.println("Player has won with blackjack!");
               x.bigWin();
            } else {
                System.out.println("Player has won");
                x.win();
            }
        }

	}

    public void playerTurn(Player x) {
		char r = ' ';
        if (x.getBet() > 0) {

			// Ensure we are still looking for input.
			while (r != 'S' && x.getPoints() <= 21 ) {
                r = ' ';
                // System.out.println("a");
				// Ensure input is valid.
				while (!( r == 'H' || r == 'S')) {
					System.out.println("(H)it or (S)tand?");
					String reply = keyboard.next();
					r = reply.toUpperCase().charAt(0);
				}

				if (r == 'H') {
                    // System.out.println("b");
                    x.drawCard(deck.getCard());
                    x.printHand();
                }
                
                // Loop back to keep hitting until done.
                // System.out.println("c");
            }
            // System.out.println("d");

            System.out.printf("\nPlayer one final score: %d\n", x.getPoints());
            System.out.println("Turn is ending.");
        } else {
            System.out.println("Player has skipped the round.");
        }
    }
    
    public void printMoney() {
        System.out.printf("Player one's money is %d\n", one.getMoney());
        System.out.printf("Player two's money is %d\n", two.getMoney());
    }

}
