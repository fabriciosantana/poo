public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Teste de Validação de Celulares ---");

        System.out.println("\n1. Testando nome vazio...");
        try {
            Phone phone1 = new Phone("", "1234567890ABCDEF");
            System.out.println("Telefone criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        System.out.println("\n2. Testando número de série inválido (curto)...");
        try {
            Phone phone2 = new Phone("iPhone 15 Pro", "12345");
            System.out.println("Telefone criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }
        
        System.out.println("\n3. Testando número de série nulo...");
        try {
            Phone phone3 = new Phone("Samsung Galaxy S23", null);
            System.out.println("Telefone criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        System.out.println("\n4. Testando com dados válidos...");
        try {
            Phone phone4 = new Phone("Google Pixel 8", "PIXEL8-PRO-12345");
            System.out.println("Sucesso! Telefone '" + phone4.getName() + "' criado corretamente.");
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        
        System.out.println("\n--- Fim dos testes ---");
    }
}