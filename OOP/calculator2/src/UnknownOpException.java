public class UnknownOpException extends Exception {
    public UnknownOpException() {
        super("UnknownOpException");
    }

    public UnknownOpException(char ch) {
        super(ch + " is an unknown operator.");
    }

    public UnknownOpException(String message) {
        super(message);
    }
}
