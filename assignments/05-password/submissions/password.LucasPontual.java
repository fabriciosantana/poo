import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        String senhaFortalecida = fortalecerSenha(senhaOriginal);

        System.out.println("Senha fortalecida: " + senhaFortalecida);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String senhaAtual = sb.toString();
                int tempoAtual = calcularTempoDigitacao(senhaAtual);

                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = senhaAtual;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) {
            return 0;
        }

        int tempo = 2; // Primeiro caractere leva 2 segundos
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1; // Igual ao anterior, 1 segundo
            } else {
                tempo += 2; // Diferente do anterior, 2 segundos
            }
        }
        return tempo;
    }
}


