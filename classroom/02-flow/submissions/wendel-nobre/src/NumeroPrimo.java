import java.util.Scanner;

public class NumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

        if (numero <= 1) {
            System.out.println("NAO PRIMO");
        } else {
            boolean ehPrimo = true;

            for (int divisor = 2; divisor <= numero / divisor; divisor++) {
                if (numero % divisor == 0) {
                    ehPrimo = false;
                    break; 
                }
            }

            if (ehPrimo) {
                System.out.println("PRIMO");
            } else {
                System.out.println("NAO PRIMO");
            }
        }

        scanner.close();
    }
}