public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("NegativeNumberException");
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}
