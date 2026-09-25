import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoApp {

    public static void main(String[] argumentos) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Numerador: ");
            int numerador = scanner.nextInt();

            System.out.print("Denominador: ");
            int denominador = scanner.nextInt();

            int resultado = numerador / denominador;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException erro) {
            System.out.println("DENOMINADOR INVALIDO");
        } catch (InputMismatchException erro) {
            // a leitura fica dentro do try para que texto no lugar de numero tambem
            // produza mensagem, em vez de encerrar o programa com stack trace
            System.out.println("Informe apenas números inteiros.");
        }

        // o programa continua depois da exceção, em vez de ser encerrado por ela
        System.out.println("Execução concluída.");

        scanner.close();
    }
}
