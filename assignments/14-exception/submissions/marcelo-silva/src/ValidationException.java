public class ValidationException extends Exception {

    
    public ValidationException(String message) {
        // Chama o construtor da superclasse (Exception) para armazenar a mensagem.
        super(message);
    }

     
    public ValidationException(String message, Throwable cause) {
        // Chama o construtor da superclasse para armazenar a mensagem e a causa.
        super(message, cause);
    }
}