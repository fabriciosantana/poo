import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = sc.nextLine().trim();

        if (s.length() < 1 || s.length() > 10) {
            System.out.println("Erro! A senha precisa ter entre 1 e 10 caracteres.");
            return;
        }

        if (!s.matches("[a-z]+")) {
            System.out.println("Erro! A senha precisa ter apenas letras minúsculas de a-z.");
            return;
        }

        String fortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + fortalecida);
    }   

    public static String fortalecerSenha(String s) {
        String melhor = null;
        int melhorTempo = -1;

        for (int pos = 0; pos <= s.length(); pos++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String candidata = s.substring(0, pos) + ch + s.substring(pos);
                int tempo = calcularTempoDigitacao(candidata);
                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhor = candidata;
                }
            }
        }
        return melhor;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) return 0;
        int tempo = 2;
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }
}