import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = scanner.nextLine();

        // Validação
        if (s.length() < 1 || s.length() > 10) {
            System.out.println("Senha inválida! O tamanho deve ser entre 1 e 10.");
            return;
        }

        String novaSenha = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + novaSenha);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int melhorTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {

                String nova = s.substring(0, i) + c + s.substring(i);

                int tempo = calcularTempoDigitacao(nova);

                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhorSenha = nova;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
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