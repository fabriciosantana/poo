import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        if (senhaOriginal.length() >= 1 && senhaOriginal.length() <= 10) {
            String senhaFortalecida = fortalecerSenha(senhaOriginal);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        } else {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
        }

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String senhaCandidata = sb.toString();

                int tempoAtual = calcularTempoDigitacao(senhaCandidata);

                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = senhaCandidata;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) {
            return 0;
        }

        int tempo = 2;
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