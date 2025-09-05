package Lucas_Pontual.src.password;

import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        if (senhaOriginal.length() < 1 || senhaOriginal.length() > 10) {
            System.out.println("Erro: A senha deve ter entre 1 e 10 caracteres.");
        } else {
            String senhaFortalecida = fortalecerSenha(senhaOriginal);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        }

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = -1;

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i <= s.length(); i++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempoAtual = calcularTempoDigitacao(novaSenha);

                if (tempoAtual > maiorTempo) {
                    maiorTempo = tempoAtual;
                    melhorSenha = novaSenha;
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
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}


