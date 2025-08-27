public class PhoneApp {
    public static void main(String[] args) {
        // Teste 1: Nome vazio
        try {
            new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 2: Número de série inválido (menos de 16 dígitos)
        try {
            new Phone("Smartphone", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 3: Dados válidos
        try {
            Phone validPhone = new Phone("Feature Phone", "9876543210987654");
            System.out.println("Telefone criado com sucesso: " + validPhone.getName() + " - " + validPhone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


