
import java.util.Scanner;

class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senha = scanner.next();
        System.out.println("Senha fortalecida: " + fortalecerSenha(senha));
        scanner.close();
    }

    public static String fortalecerSenha(String senha) {
        String melhorSenha = senha;
        int maiorTempo = calcularTempoDigitacao(senha);

        for (int i = 0; i <= senha.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = senha.substring(0, i) + c + senha.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);
                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;
        int tempo = 2;
        for (int i = 1; i < senha.length(); i++) {
            tempo += senha.charAt(i) == senha.charAt(i - 1) ? 1 : 2;
        }
        return tempo;
    }
}