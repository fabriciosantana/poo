import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = lerSenhaValida(sc);
        String reforcada = fortalecerSenha(s);

        System.out.println("Senha fortalecida: " + reforcada);
        sc.close();
    }

    private static String lerSenhaValida(Scanner sc) {
        while (true) {
            System.out.print("Digite a senha: ");
            String s = sc.nextLine().trim();
            if (s.length() >= 1 && s.length() <= 10 && s.chars().allMatch(c -> c >= 'a' && c <= 'z')) {
                return s;
            }
            System.out.println("Entrada inválida. Use de 1 a 10 letras minúsculas (a-z).");
        }
    }
    public static String fortalecerSenha(String s) {
        int n = s.length();
        String melhor = null;
        int melhorTempo = -1;

        for (int pos = 0; pos <= n; pos++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String candidato = s.substring(0, pos) + ch + s.substring(pos);
                int tempo = calcularTempoDigitacao(candidato);
                if (tempo > melhorTempo || (tempo == melhorTempo && candidato.compareTo(melhor) < 0)) {
                    melhorTempo = tempo;
                    melhor = candidato;
                }
            }
        }
        return melhor;
    }
    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;
        int tempo = 2; 
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }
}
