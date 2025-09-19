public class ValidationException extends Exception {

    // Construtor que recebe só a mensagem
    public ValidationException(String message) {
        super(message);
    }

    // Construtor que recebe mensagem e causa
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
