public class InvalidCardException extends Exception {

	public InvalidCardException() {
		super("Invalid card. Please try again.");
	}

	public InvalidCardException(String message) {
		super(message);
    }
    
}