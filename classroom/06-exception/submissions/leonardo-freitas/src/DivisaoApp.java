import java.util.Scanner;

public class DivisaoApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Numerador: ");
            int numerador = scanner.nextInt();
            System.out.print("Denominador: ");
            int denominador = scanner.nextInt();

            try {
                System.out.println("Resultado: " + (numerador / denominador));
            } catch (ArithmeticException e) {
                System.out.println("DENOMINADOR INVALIDO");
            }
        }
    }
}
