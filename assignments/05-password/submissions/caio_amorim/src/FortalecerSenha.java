import java.util.Scanner;

public class FortalecerSenha {

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }
        int tempo = 2; // Primeiro caractere leva 2 segundos
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = s;
        int maxTempo = calcularTempoDigitacao(s);

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempoAtual = calcularTempoDigitacao(novaSenha);
                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        if (senhaOriginal.length() < 1 || senhaOriginal.length() > 10) {
            System.out.println("Erro: O comprimento da senha deve estar entre 1 e 10 caracteres.");
        } else {
            String senhaFortalecida = fortalecerSenha(senhaOriginal);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        }
        scanner.close();
    }
}