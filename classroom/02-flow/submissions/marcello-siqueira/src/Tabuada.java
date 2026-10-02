import java.util.Scanner;

public class Tabuada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
            long produto = (long) numero * multiplicador;
            System.out.println(numero + " x " + multiplicador + " = " + produto);
        }

        scanner.close();
    }
}
