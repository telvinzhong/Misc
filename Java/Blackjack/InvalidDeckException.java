public class InvalidDeckException extends Exception {

	public InvalidDeckException(String message) {
		super(message);

	}

	public InvalidDeckException() {
		super("Invalid Deck operation.");
	}
}