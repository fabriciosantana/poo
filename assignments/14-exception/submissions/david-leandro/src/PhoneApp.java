public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Teste de Criação de Objetos Phone ---");

        // 1. Tentar criar um objeto Phone com nome vazio
        System.out.println("\n--- Teste 1: Nome Vazio ---");
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            // Captura a exceção e imprime a mensagem adequada
            System.err.println("Erro ao criar telefone: " + e.getMessage());
        }


        // 2. Tentar criar um objeto Phone com número de série inválido (menos de 16 caracteres)
        System.out.println("\n--- Teste 2: Serial Inválido ---");
        try {
            Phone phone2 = new Phone("Galaxy S23", "12345");
        } catch (ValidationException e) {
            // Captura a exceção e imprime a mensagem adequada
            System.err.println("Erro ao criar telefone: " + e.getMessage());
        }


        // 3. Criar um objeto Phone com dados válidos
        System.out.println("\n--- Teste 3: Dados Válidos ---");
        try {
            Phone phone3 = new Phone("Google Pixel 8", "AABBCCDDEEFF0011");
            // Se a exceção não for lançada, esta linha é alcançada
            System.out.println("Sucesso: Objeto 'Google Pixel 8' criado e validado.");
        } catch (ValidationException e) {
            // Se, por algum motivo, a exceção fosse lançada (o que não deve ocorrer aqui), ela seria capturada
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}