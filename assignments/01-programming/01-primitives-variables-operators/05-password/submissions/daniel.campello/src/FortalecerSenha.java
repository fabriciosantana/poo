import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        String senhaFortalecida = fortalecerSenha(senhaOriginal);

        System.out.println("Senha fortalecida: " + senhaFortalecida);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String bestPassword = "";
        int maxTime = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String newPassword = sb.toString();
                int currentTime = calcularTempoDigitacao(newPassword);

                if (currentTime > maxTime) {
                    maxTime = currentTime;
                    bestPassword = newPassword;
                }
            }
        }
        return bestPassword;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }
        int time = 2;
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                time += 1;
            } else {
                time += 2;
            }
        }
        return time;
    }
}