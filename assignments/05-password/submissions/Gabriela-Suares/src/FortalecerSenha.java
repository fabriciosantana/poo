import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senha = scanner.next();
        scanner.close();

        String melhorSenha = senha;
        int maxTempo = 0;

        for (int i = 0; i <= senha.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = senha.substring(0, i) + c + senha.substring(i);
                int tempo = 2;
                for (int j = 1; j < novaSenha.length(); j++)
                    tempo += (novaSenha.charAt(j) == novaSenha.charAt(j - 1)) ? 1 : 2;
                
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        System.out.println("Senha fortalecida: " + melhorSenha);
    }
}

