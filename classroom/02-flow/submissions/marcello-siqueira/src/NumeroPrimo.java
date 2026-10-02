import java.util.Scanner;

public class NumeroPrimo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        boolean primo = numero > 1;

        // divisor <= numero / divisor equivale a divisor * divisor <= numero, sem estourar o int
        for (int divisor = 2; divisor <= numero / divisor; divisor++) {
            if (numero % divisor == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println("PRIMO");
        } else {
            System.out.println("NAO PRIMO");
        }

        scanner.close();
    }
}
