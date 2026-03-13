import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.println("Senha fortalecida: " + fortalecerSenha(senha));
    }

    public static String fortalecerSenha(String s) {
        validarSenha(s);

        String melhorSenha = "";
        int melhorTempo = -1;

        for (int posicao = 0; posicao <= s.length(); posicao++) {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                String candidata = s.substring(0, posicao) + letra + s.substring(posicao);
                int tempo = calcularTempoDigitacao(candidata);

                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhorSenha = candidata;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
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

    private static void validarSenha(String senha) {
        if (senha == null) {
            throw new IllegalArgumentException("A senha n\u00E3o pode ser nula.");
        }
        if (senha.length() < 1 || senha.length() > 10) {
            throw new IllegalArgumentException("A senha deve ter entre 1 e 10 caracteres.");
        }
    }
}
