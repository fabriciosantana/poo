import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraExcecoesApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Primeiro número: ");
                int a = scanner.nextInt();
                System.out.print("Operador (+, -, * ou /): ");
                String operador = scanner.next();
                System.out.print("Segundo número: ");
                int b = scanner.nextInt();

                switch (operador) {
                    case "+" -> System.out.println("Resultado: " + (a + b));
                    case "-" -> System.out.println("Resultado: " + (a - b));
                    case "*" -> System.out.println("Resultado: " + (a * b));
                    case "/" -> System.out.println("Resultado: " + (a / b));
                    default -> System.out.println("OPERADOR INVALIDO");
                }
            } catch (InputMismatchException e) {
                System.out.println("NUMERO INVALIDO");
            } catch (ArithmeticException e) {
                System.out.println("DENOMINADOR INVALIDO");
            }

            // Um catch (Exception) não deve vir antes dos específicos, pois os tornaria inalcançáveis.
        }
    }
}
