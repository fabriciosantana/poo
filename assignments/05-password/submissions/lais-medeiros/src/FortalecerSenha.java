import java.util.Scanner;

public class FortalecerSenha {

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int melhorTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
    
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
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
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = sc.next();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Erro: o comprimento da senha deve estar entre 1 e 10.");
        } else {
            String fortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + fortalecida);
        }

        sc.close();
    }
}