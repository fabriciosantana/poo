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
            StringBuilder base = new StringBuilder(s);
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = base.insert(i, c).toString();
                int tempoAtual = calcularTempoDigitacao(novaSenha);

                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
                
                base.deleteCharAt(i);
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        int tempoTotal = 2;

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1;
            } else {
                tempoTotal += 2;
            }
        }
        return tempoTotal;
    }
}
