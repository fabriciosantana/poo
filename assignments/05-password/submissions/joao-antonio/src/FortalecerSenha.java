import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (senha.length() < 6 || senha.length() > 10) {
            System.out.println("Senha fraca: deve ter entre 6 e 10 caracteres.");
        } else {
            String senhaFortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        }
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c); // insere uma letra minúscula
                String novaSenha = sb.toString();

                int tempoAtual = calcularTempoDigitacao(novaSenha);
                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }
        int tempoTotal = 2; // primeiro caractere sempre leva 2s

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1; // mesmo caractere -> 1s
            } else {
                tempoTotal += 2; // diferente -> 2s
            }
        }
        return tempoTotal;
    }
}
