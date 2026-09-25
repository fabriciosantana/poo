import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOperacoesApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean executando = true;

            while (executando) {
                exibirMenu();
                try {
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1 -> dividir(scanner);
                        case 2 -> converter(scanner);
                        case 0 -> executando = false;
                        default -> System.out.println("OPCAO INVALIDA");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("NUMERO INVALIDO");
                    scanner.nextLine();
                } catch (ArithmeticException e) {
                    System.out.println("DENOMINADOR INVALIDO");
                } catch (NumberFormatException e) {
                    System.out.println("NUMERO INVALIDO");
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("1 - Dividir dois números");
        System.out.println("2 - Converter texto em inteiro");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }

    private static void dividir(Scanner scanner) {
        System.out.print("Numerador: ");
        int numerador = scanner.nextInt();
        System.out.print("Denominador: ");
        int denominador = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Resultado: " + (numerador / denominador));
    }

    private static void converter(Scanner scanner) {
        System.out.print("Texto para converter: ");
        String texto = scanner.nextLine();
        int numero = Integer.parseInt(texto);
        System.out.println("Número: " + numero);
    }
}
