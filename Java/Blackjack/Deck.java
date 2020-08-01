import java.util.*;

public class Deck extends Exception {
    /**
     * This class represents a standard 52-card playing deck.
     */

    // A Hashset is notably not the best data structure. 
    // List descendants can have card orders and better support for random.
    // Familiarizing myself with Hashsets and favoring speed in this program.
    HashSet<Card> deck = new HashSet <Card>();
    int count; // Number of cards remaining in deck.

	public Deck() {
		try{
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('H', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('S', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('C', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('D', i));
            }	
		} catch(InvalidCardException e) {
			System.out.println("Shouldn't see this - error creating deck.");
        }
        count = 52; // 51 because we are popping with getCard using iterator.next
    }
    
    // Methods. 

	public Card getCard() throws IndexOutOfBoundsException {
        try {
            if (this.isEmpty()) {
                System.out.println("Shuffling cards!");
                this.shuffle();
            }

            Random random = new Random();
            int randomNumber = random.nextInt(count);
            Iterator<Card> iterator = deck.iterator();
            int currentIndex = 0;
            Card randomElement = null;
            
            while (iterator.hasNext()) {            
                    
                randomElement = iterator.next();
                
                //if current index is equal to random number
                if (currentIndex == randomNumber) {
                    this.count -= 1;
                    Card temp = new Card(randomElement);
                    deck.remove(randomElement);
                    return temp;
                }            
                
                //increase the current index
                currentIndex++;
            }

            this.count -= 1;
            Card temp = new Card(randomElement);
            deck.remove(randomElement);
            return temp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Should be unreachable - getCard failed.");
            return null;
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public void shuffle() {
        // Clear deck and create new set of 52 cards. 
        deck.clear();

        try{
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('H', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('S', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('C', i));
            }
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card('D', i));
            }	
		} catch(InvalidCardException e) {
			System.out.println("Shouldn't see this - error creating deck.");
        }

        count = 52;
    }
        
    // Prints the entire deck in order with toString method.
	// public String toString(){

	// 	String str = "";

	// 	for (int i = 0; i < deck.length; i++) {
	// 		str +=	deck[i].toString() + " ";
	// 	}
	// 	return str;
	// }
}
