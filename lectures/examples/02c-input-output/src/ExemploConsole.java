import java.io.Console;

public class ExemploConsole {
    public static void main(String[] args) {
        // Obtém a instância do console do sistema
        Console console = System.console();

        // Verifica se o console está disponível
        if (console == null) {
            System.out.println("Console não disponível. Execute no terminal (fora da IDE).");
            return;
        }

        String nome = console.readLine("Digite seu nome: ");

        // readPassword não exibe o que o usuário digita (ótimo para senhas)
        char[] senha = console.readPassword("Digite sua senha: ");

        String idadeStr = console.readLine("Digite sua idade: ");
        int idade = Integer.parseInt(idadeStr);

        System.out.printf("Olá %s, você tem %d anos.%n", nome, idade);

        // Como readPassword retorna um array de char, boa prática é limpar depois
        java.util.Arrays.fill(senha, ' ');
    }
}
