public class ValidationException extends Exception {

    /**
     * Construtor que recebe a mensagem de erro.
     * @param message A descrição específica do erro de validação.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Construtor que recebe a mensagem de erro e a causa original (encadeamento de exceções).
     * @param message A descrição específica do erro de validação.
     * @param cause A exceção Throwable que causou este erro de validação.
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}