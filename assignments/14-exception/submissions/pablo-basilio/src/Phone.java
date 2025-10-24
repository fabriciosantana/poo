public class PhoneApp {

    public static void main(String[] args) {

        System.out.println("--- Testes de Validação da Classe Phone ---");

        System.out.println("\n--- Teste 1: Nome Vazio ---");
        try {
            Phone phone1 = new Phone("", "1234567890123456");
            System.out.println("SUCESSO (Não deveria acontecer): " + phone1);
        } catch (ValidationException e) {
            System.err.println("ERRO Capturado (Esperado): " + e.getMessage());
        }

        System.out.println("\n--- Teste 2: Serial Curto ---");
        try {
            Phone phone2 = new Phone("Modelo X Pro", "12345");
            System.out.println("SUCESSO (Não deveria acontecer): " + phone2);
        } catch (ValidationException e) {
            System.err.println("ERRO Capturado (Esperado): " + e.getMessage());
        }
        
        System.out.println("\n--- Teste 3: Serial Nulo ---");
        try {
            Phone phone3 = new Phone("Modelo X Pro", null); 
            System.out.println("SUCESSO (Não deveria acontecer): " + phone3);
        } catch (ValidationException e) {
            System.err.println("ERRO Capturado (Esperado): " + e.getMessage());
        }

        System.out.println("\n--- Teste 4: Dados Válidos ---");
        try {
            Phone phone4 = new Phone("Galaxy S23", "ABC123DEF456GHI7");
            System.out.println("SUCESSO: Objeto Phone criado com sucesso!");
            System.out.println(phone4);
        } catch (ValidationException e) {
            System.err.println("ERRO Inesperado: Validação falhou para dados válidos: " + e.getMessage());
        }
        
        System.out.println("\nFim do programa de testes.");
    }
}