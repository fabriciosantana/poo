import java.util.Scanner;

public class PositivoNegativoZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (numero > 0) {
            System.out.println("POSITIVO");
        } else if (numero < 0) {
            System.out.println("NEGATIVO");
        } else {
            System.out.println("ZERO");
        }

        scanner.close();
    }
}
