public class InvalidReadingException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidReadingException(String message) {
        super(message);
    }

    public InvalidReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
