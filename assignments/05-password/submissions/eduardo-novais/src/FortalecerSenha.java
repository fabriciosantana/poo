import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int count = 0;
        String password, strongPassword;

        do {
            System.out.print("Digite sua senha (0 a 10): ");
            password = input.nextLine();

            if (password.length() <= 0 || password.length() >= 10) {
                System.out.println("Senha fora do intervalo permitido (0 a 10). Tente novamente.");

                count = 0;
            } else {
                count = 1;
            }

        } while (count == 0);

        strongPassword = fortalecerSenha(password);

        System.out.println("Senha fortalecida: " + strongPassword);

        input.close();
    }

    public static String fortalecerSenha(String s) {
        String bestPassword = "";
        int loggerTime = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newPassword = s.substring(0, i) + c + s.substring(i);

                int time = calcularTempoDigitacao(newPassword);
                if (time > loggerTime) {
                    loggerTime = time;
                    bestPassword = newPassword;
                }
            }
        }

        return bestPassword;
    }

    public static int calcularTempoDigitacao(String password) {
        int time = 2;

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                time += 1;
            } else {
                time += 2;
            }
        }

        return time;
    }
}
