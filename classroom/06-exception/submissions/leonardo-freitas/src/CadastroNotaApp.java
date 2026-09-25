import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroNotaApp {
    static double lerNota(Scanner scanner) throws InputMismatchException {
        double nota = scanner.nextDouble();
        if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        return nota;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Double notaRegistrada = null;

            while (notaRegistrada == null) {
                System.out.print("Digite uma nota entre 0 e 10: ");
                try {
                    double candidata = lerNota(scanner);
                    notaRegistrada = candidata;
                } catch (InputMismatchException e) {
                    System.out.println("NOTA INVALIDA");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("NOTA INVALIDA");
                }
            }

            System.out.println("NOTA REGISTRADA");
        }
    }
}
