import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraExcecoesApp {

    public static void main(String[] argumentos) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Primeiro número: ");
            int primeiro = scanner.nextInt();

            System.out.print("Segundo número: ");
            int segundo = scanner.nextInt();

            System.out.print("Operador (+, -, *, /): ");
            char operador = scanner.next().charAt(0);

            switch (operador) {
                case '+':
                    System.out.println("Resultado: " + (primeiro + segundo));
                    break;
                case '-':
                    System.out.println("Resultado: " + (primeiro - segundo));
                    break;
                case '*':
                    System.out.println("Resultado: " + (primeiro * segundo));
                    break;
                case '/':
                    System.out.println("Resultado: " + (primeiro / segundo));
                    break;
                default:
                    System.out.println("OPERADOR INVALIDO");
                    break;
            }
        } catch (InputMismatchException erro) {
            System.out.println("Os dois primeiros valores precisam ser números inteiros.");
        } catch (ArithmeticException erro) {
            System.out.println("Não é possível dividir por zero.");
        }
        // um catch (Exception) antes destes nem compilaria: Exception e supertipo dos dois,
        // entao os blocos especificos ficariam inalcancaveis. Mesmo que compilasse, capturar
        // o tipo mais generico primeiro esconderia a causa real e impediria tratamento distinto.

        scanner.close();
    }
}
