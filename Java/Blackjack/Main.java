

public class Main {
    public static void main(String[] args) throws Exception {
        Blackjack game = new Blackjack();

        game.beginGame();
        while (true) {

            game.placeBets();
            game.deck.shuffle(); // No counting.
            game.dealCards();
            System.out.println("");

            game.printBoard();
            if (game.checkBlackjack()) {
                System.out.println("Showing game status: ");
                game.printMoney();
                continue;
            }
            System.out.println("------------------------------------");
            System.out.println("\nPlayer One's Turn:");
            game.one.printHand();
            game.playerTurn(game.one);

            System.out.println("------------------------------------");
            System.out.println("\nPlayer Two's Turn:");
            game.two.printHand();
            game.playerTurn(game.two);

            game.dealer.dealerPlay(game.deck);

            System.out.println("------------------------------------");
            System.out.println("\nEveryone has played.");
            game.printBoard();
            System.out.println("------------------------------------");
            System.out.println("\nPlayer one results: ");
            game.collect(game.one);
            System.out.println("\nPlayer two results: ");
            game.collect(game.two);

            System.out.println("\nShowing game status: ");
            game.printMoney();
            break;
        }
    }
}
