import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String s = scanner.next();
        scanner.close();

        String senhaFortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + senhaFortalecida);
    }

    public static String fortalecerSenha(String s) {
        if (s.isEmpty()) {
            return "aa";
        }
        
        String melhorSenha = "";
        int Tempomax = -1;
        
        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);
                
                if (tempo > Tempomax) {
                    Tempomax = tempo;
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
