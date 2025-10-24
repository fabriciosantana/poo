public class PhoneApp {
    public static void main(String[] args) {
        try {
            // Teste 1: nome vazio
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        try {
            // Teste 2: número de série com menos de 16 dígitos
            Phone phone2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        try {
            // Teste 3: dados válidos
            Phone phone3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso: " + phone3);
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
