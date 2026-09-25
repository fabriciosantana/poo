import java.util.InputMismatchException;
import java.util.Scanner;

public class LeituraInteirosApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer valor = null;

            while (valor == null) {
                System.out.print("Digite um número inteiro: ");
                try {
                    valor = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("ENTRADA INVALIDA");
                    scanner.nextLine();
                }
            }

            System.out.println("Valor lido: " + valor);
        }
    }
}
