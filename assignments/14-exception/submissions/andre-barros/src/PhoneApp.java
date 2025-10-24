public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Iniciando testes de criação de Phones ---");

        try {
            System.out.println("\n[Teste 1] Tentando criar um Phone com nome vazio...");
            Phone phone1 = new Phone("", "ABCDEFGHIJKLMNOP");
            System.out.println("Sucesso: " + phone1);
        } catch (ValidationException e) {
            System.out.println("Falha esperada capturada: " + e.getMessage());
        }

        try {
            System.out.println("\n[Teste 2] Tentando criar um Phone com serial inválido...");
            Phone phone2 = new Phone("Galaxy S25", "12345");
            System.out.println("Sucesso: " + phone2);
        } catch (ValidationException e) {
            System.out.println("Falha esperada capturada: " + e.getMessage());
        }
        
        try {
            System.out.println("\n[Teste 3] Tentando criar um Phone com dados válidos...");
            Phone validPhone = new Phone("iPhone 17 Pro", "1A2B3C4D5E6F7G8H");
            System.out.println("Telefone criado com sucesso! -> " + validPhone);
        } catch (ValidationException e) {
            System.out.println("Erro inesperado ao criar telefone válido: " + e.getMessage());
        }

        System.out.println("\n--- Testes finalizados ---");
    }
}