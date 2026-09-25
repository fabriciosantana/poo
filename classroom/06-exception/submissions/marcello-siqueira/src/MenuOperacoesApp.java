import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOperacoesApp {

    public static void main(String[] argumentos) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("1 - Dividir dois números");
            System.out.println("2 - Converter texto em inteiro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    dividir(scanner);
                } else if (opcao == 2) {
                    converter(scanner);
                } else if (opcao != 0) {
                    System.out.println("Opção inexistente.");
                }
            } catch (InputMismatchException erro) {
                scanner.nextLine();
                System.out.println("Informe apenas números inteiros.");
            } catch (ArithmeticException erro) {
                System.out.println("Não é possível dividir por zero.");
            } catch (NumberFormatException erro) {
                System.out.println("O texto informado não representa um inteiro.");
            }
        }

        System.out.println("Programa encerrado.");

        scanner.close();
    }

    static void dividir(Scanner scanner) {
        System.out.print("Numerador: ");
        int numerador = scanner.nextInt();

        System.out.print("Denominador: ");
        int denominador = scanner.nextInt();

        System.out.println("Resultado: " + (numerador / denominador));
    }

    static void converter(Scanner scanner) {
        System.out.print("Texto: ");
        String texto = scanner.next();

        System.out.println("Convertido: " + Integer.parseInt(texto));
    }
}
