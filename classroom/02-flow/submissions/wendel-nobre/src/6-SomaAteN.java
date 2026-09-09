import java.util.Scanner;

public class SomaAteN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            int soma = 0;
            for (int i = 1; i <= n; i++) {
                soma += i;
            }
            System.out.println(soma);
        }

        scanner.close();
    }
}