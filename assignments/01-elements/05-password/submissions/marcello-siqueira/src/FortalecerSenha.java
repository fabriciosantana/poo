import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.hasNextLine() ? scanner.nextLine() : "";
        scanner.close();

        boolean valida = senha.length() >= 1 && senha.length() <= 10;
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);
            if (caractere < 'a' || caractere > 'z') {
                valida = false;
            }
        }
        if (!valida) {
            System.out.println("Senha inválida: use de 1 a 10 letras minúsculas (a-z).");
            return;
        }

        System.out.println("Senha fortalecida: " + fortalecerSenha(senha));
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = s;
        int melhorTempo = -1;
        // testa cada posicao com cada letra; em empate fica a primeira encontrada
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
        int tempo = 0;
        for (int i = 0; i < senha.length(); i++) {
            if (i > 0 && senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}
