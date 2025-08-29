import java.util.Scanner;

public class FortalecerSenha {

    // método main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada do usuário
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
        } else {
            // fortalecer senha
            String novaSenha = fortalecerSenha(senha);

            // saída
            System.out.println("Senha fortalecida: " + novaSenha);
        }

        scanner.close();
    }

    // método que fortalece a senha testando todas inserções possíveis
    public static String fortalecerSenha(String s) {
        String melhorSenha = null;
        int maxTempo = -1;

        // testar todas as posições de inserção
        for (int i = 0; i <= s.length(); i++) {
            // testar todas as letras do alfabeto
            for (char c = 'a'; c <= 'z'; c++) {
                String candidato = s.substring(0, i) + c + s.substring(i);

                int tempo = calcularTempoDigitacao(candidato);

                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = candidato;
                }
            }
        }

        return melhorSenha;
    }

    // método que calcula o tempo de digitação de uma senha
    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;

        int tempo = 2; // primeiro caractere sempre leva 2s

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }

        return tempo;
    }
}
