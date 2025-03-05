import java.util.Random;
import java.util.Scanner;

public class FortalecerSenha {
    public static String fortalecerSenha (String s) {
        Random rand = new Random();
        char letra = (char) (rand.nextInt(26) + 'a');
        for (int pos = 1; pos < s.length(); pos++) {
            if (s.charAt(pos) == s.charAt(pos - 1)) {
                while (s.charAt(pos) == letra)
                    letra = (char) (rand.nextInt(26) + 'a');
                return new StringBuilder(s).insert(pos, letra).toString();
            }
        }
        return new StringBuilder(s).insert(s.length() - rand.nextInt(s.length()), letra).toString();
    }
    public static int calcularTempoDigitacao (String s) {
        int tempo = 2;
        for (int pos = 1; pos < s.length(); pos++) {
            if (s.charAt(pos) == s.charAt(pos - 1)) tempo++;
            else tempo += 2;
        }
        return tempo;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String s = scanner.nextLine();
        
        if (1 < s.length() & s.length() > 10) {
            scanner.close();
            throw new java.lang.Error("Senha é maior que 10 caracteres.");
        }

        String senha_fortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + senha_fortalecida);
        System.out.println("Tempo estimado de digitação da senha: " + calcularTempoDigitacao(senha_fortalecida));
        scanner.close();
    }
}
