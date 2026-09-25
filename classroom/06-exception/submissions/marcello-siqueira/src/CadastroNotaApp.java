import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroNotaApp {

    public static void main(String[] argumentos) {
        Scanner scanner = new Scanner(System.in);
        double notaRegistrada = 0;
        boolean registrada = false;

        while (!registrada) {
            try {
                notaRegistrada = lerNota(scanner);
                registrada = true;
                System.out.println("NOTA REGISTRADA");
            } catch (InputMismatchException erro) {
                scanner.nextLine();
                System.out.println("Entrada inválida. Informe um número.");
            } catch (IllegalArgumentException erro) {
                System.out.println("Nota recusada: " + erro.getMessage());
            }
            // notaRegistrada so e atribuida quando lerNota devolve com sucesso,
            // entao uma tentativa recusada nao altera o valor ja aceito
        }

        System.out.println("Nota final: " + notaRegistrada);

        scanner.close();
    }

    static double lerNota(Scanner scanner) throws InputMismatchException {
        System.out.print("Nota entre 0 e 10: ");
        double nota = scanner.nextDouble();

        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("a nota precisa estar entre 0 e 10, recebido " + nota);
        }

        return nota;
    }
}
