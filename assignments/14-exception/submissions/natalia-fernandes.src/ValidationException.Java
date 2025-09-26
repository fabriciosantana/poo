// classe de excecao personalizada
public class ValidationException extends Exception {

    // construtor que recebe apenas mensagem
    public ValidationException(String message) {
        super(message);
    }

    // construtor que recebe mensagem e causa
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
