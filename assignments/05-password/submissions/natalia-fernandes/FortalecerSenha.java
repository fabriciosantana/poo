import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = sc.nextLine().trim();

        // Validações
        if (s.length() < 1 || s.length() > 10) {
            System.out.println("Entrada inválida: o comprimento deve estar entre 1 e 10.");
            sc.close();
            return;
        }
        if (!s.matches("[a-z]+")) {
            System.out.println("Entrada inválida: use apenas letras minúsculas de a-z.");
            sc.close();
            return;
        }

        String reforcada = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + reforcada);

        sc.close();
    }

    /**
     * Insere exatamente uma letra 'a'..'z' em qualquer posição de s
     * maximizando o tempo de digitação. Em caso de empate, retorna
     * a menor string em ordem lexicográfica (critério estável).
     */
    public static String fortalecerSenha(String s) {
        int n = s.length();
        String melhor = null;
        int melhorTempo = -1;

        for (int pos = 0; pos <= n; pos++) {         // posições 0..n
            for (char c = 'a'; c <= 'z'; c++) {      // letras a..z
                String cand = s.substring(0, pos) + c + s.substring(pos);
                int tempo = calcularTempoDigitacao(cand);

                if (tempo > melhorTempo ||
                   (tempo == melhorTempo && (melhor == null || cand.compareTo(melhor) < 0))) {
                    melhorTempo = tempo;
                    melhor = cand;
                }
            }
        }
        return melhor;
    }

    /**
     * Calcula o tempo de digitação:
     * - 1º caractere: 2s
     * - seguinte: +1s se igual ao anterior; +2s se diferente do anterior
     */
    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;

        int tempo = 2; // primeiro caractere
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }
}
