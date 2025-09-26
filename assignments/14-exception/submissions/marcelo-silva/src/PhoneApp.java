
public class PhoneApp {
    public static void main(String[] args) {
        System.out.println("--- Testando Validação e Tratamento de Exceções ---");

        // Teste 1: Tentar criar um objeto Phone com nome vazio
        System.out.println("\n1. Tentando criar um telefone com nome vazio...");
        try {
            // Tentativa de criar um objeto que vai falhar
            Phone p1 = new Phone("", "1234567890ABCDEF");
            // Esta linha não deve ser alcançada
            System.out.println("Telefone '" + p1.getName() + "' criado com sucesso.");
        } catch (ValidationException e) {
            // Captura a exceção e exibe a mensagem de erro de forma amigável
            System.err.println("-> Erro capturado (esperado): " + e.getMessage());
        }

        //  Teste 2: Tentar criar um objeto Phone com número de série inválido 
        System.out.println("\n2. Tentando criar um telefone com número de série com menos de 16 caracteres...");
        try {
            // Tentativa de criar um objeto que também vai falhar
            Phone p2 = new Phone("iPhone 17", "12345");
            // Esta linha não deve ser alcançada
            System.out.println("Telefone '" + p2.getName() + "' criado com sucesso.");
        } catch (ValidationException e) {
            // Captura a exceção e exibe a mensagem
            System.err.println("-> Erro capturado (esperado): " + e.getMessage());
        }

        //  Teste 3: Criar um objeto Phone com dados válidos 
        System.out.println("\n3. Tentando criar um telefone com dados válidos...");
        try {
            // Esta criação deve funcionar
            Phone p3 = new Phone("Galaxy S25 Ultra", "SAMSUNG-SN-2025-X"); // Exatamente 16 caracteres
            // Se a linha acima não lançar exceção, esta linha será executada
            System.out.println("-> Sucesso! Telefone '" + p3.getName() + "' criado.");
        } catch (ValidationException e) {
            // Este bloco não deve ser executado, mas está aqui por segurança
            System.err.println("-> Erro inesperado: " + e.getMessage());
        }
    }
}
