import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            int a = 0;
            int b = 1;

            for (int i = 1; i <= n; i++) {
                System.out.print(a + (i == n ? "" : " "));
                
                int proximo = a + b;
                a = b;
                b = proximo;
            }
            System.out.println();
        }

        scanner.close();
    }
}