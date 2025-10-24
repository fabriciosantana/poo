public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Início da Demonstração de Tratamento de Exceção ---");
        
        System.out.println("\n[Teste 1: Nome vazio]");
        try {
            Phone p1 = new Phone(" ", "1234567890123456"); 
            System.out.println("Sucesso (Erro de Lógica): " + p1);
        } catch (ValidationException e) {
            System.err.println("Exceção capturada com sucesso:");
            System.err.println("  Mensagem: " + e.getMessage());
        }
        
        System.out.println("\n[Teste 2: Número de série inválido (curto)]");
        try {
            Phone p2 = new Phone("Modelo Y", "54321");
            System.out.println("Sucesso (Erro de Lógica): " + p2); 
        } catch (ValidationException e) {
            System.err.println("Exceção capturada com sucesso:");
            System.err.println("  Mensagem: " + e.getMessage());
        }

        System.out.println("\n[Teste 3: Dados válidos]");
        try {
            Phone p3 = new Phone("iPhone 20", "AABBCCDD11223344");
            System.out.println("Objeto criado com sucesso:");
            System.out.println("  Detalhes: " + p3);
        } catch (ValidationException e) {
            System.err.println("Erro inesperado durante a criação: " + e.getMessage());
        }
        
        System.out.println("\n--- Fim da Demonstração ---");
    }
}