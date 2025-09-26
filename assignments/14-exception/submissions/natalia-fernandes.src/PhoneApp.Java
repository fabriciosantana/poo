// programa principal de teste
public class PhoneApp {

    public static void main(String[] args) {

        // teste com nome vazio
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // teste com numero de serie invalido
        try {
            Phone p2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // teste com dados validos
        try {
            Phone p3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso: " + p3.getName() + " - " + p3.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
