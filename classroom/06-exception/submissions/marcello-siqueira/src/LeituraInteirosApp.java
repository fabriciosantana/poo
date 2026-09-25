import java.util.InputMismatchException;
import java.util.Scanner;

public class LeituraInteirosApp {

    public static void main(String[] argumentos) {
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        boolean lido = false;

        while (!lido) {
            System.out.print("Digite um número inteiro: ");
            try {
                valor = scanner.nextInt();
                lido = true;
            } catch (InputMismatchException erro) {
                // o token invalido continua no buffer do Scanner; sem descartar, o laço repetiria para sempre
                scanner.nextLine();
                System.out.println("Entrada inválida. Digite apenas um número inteiro.");
            }
        }

        System.out.println("Valor lido: " + valor);

        scanner.close();
    }
}
