public class PhoneApp {
    public static void main(String[] args) {

        try {
            Phone p1 = new Phone("", "1234567890123456");
            System.out.println("Criado: " + p1);
        } catch (ValidationException e) {
            System.out.println("Falha ao criar telefone (1): " + e.getMessage());
        }

        try {
            Phone p2 = new Phone("Modelo X", "12345");
            System.out.println("Criado: " + p2);
        } catch (ValidationException e) {
            System.out.println("Falha ao criar telefone (2): " + e.getMessage());
        }

        try {
            Phone p3 = new Phone("Modelo Y", "9876543210123456");
            System.out.println("Telefone criado com sucesso: " + p3);
        } catch (ValidationException e) {
            System.out.println("Falha inesperada ao criar telefone (3): " + e.getMessage());
        }
    }
}

