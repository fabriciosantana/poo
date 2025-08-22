import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        do {
            System.out.print("Digite a senha: ");
            password = scanner.nextLine();
        } while (password.isEmpty() || password.length() > 10);
        scanner.close();

        String newPassword = fortalecerSenha(password);
        int time = calcularTempoDigitacao(newPassword);

        System.out.println("Senha fortalecida: " + newPassword);
        System.out.printf("Tempo de digitação: %d\n", time);
    }

    public static String fortalecerSenha(String input) {
        String better = "";
        int maxTime = -1;

        for (int i = 0; i <= input.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String start = input.substring(0, i); // pega a parte da string antes da inserção
                String end = input.substring(i);       // pega a parte da string depois da inserção

                String newPassword = start + c + end;

                int actualTime = calcularTempoDigitacao(newPassword);

                if (actualTime > maxTime) {
                    maxTime = actualTime;
                    better = newPassword;
                }
            }
        }
        return better;
    }

    public static int calcularTempoDigitacao (String password) {
        if (password.isEmpty()) return 0;

        // Primeiro caracter custa 2
        int time = 2;

        for (int index = 1; index < password.length(); index++) {
            if (password.charAt(index) == password.charAt(index - 1)) {
                time += 1; // adiciona 1 segundo se o caractere for igual ao anterior
                continue;
            }

            time += 2; // adiciona 2 segundos se o caractere for diferente do anterior
        }

        return  time;
    }
}
