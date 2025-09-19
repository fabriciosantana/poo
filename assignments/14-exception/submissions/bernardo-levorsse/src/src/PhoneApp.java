public class PhoneApp {
    public static void main(String[] args) {
        // Teste 1: Nome vazio
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        // Teste 2: Número de série inválido (menos de 16 dígitos)
        try {
            Phone p2 = new Phone("iPhone", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        // Teste 3: Dados válidos
        try {
            Phone p3 = new Phone("Galaxy", "1234567890123456");
            System.out.println("Telefone criado com sucesso: " + p3.getName() + " | Serial: " + p3.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
