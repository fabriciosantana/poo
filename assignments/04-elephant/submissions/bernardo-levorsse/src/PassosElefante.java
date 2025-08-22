import java.util.InputMismatchException;
import java.util.Scanner;

public class PassosElefante {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = -1;

        while (true) {
            System.out.print("Digite a posição da casa do amigo: ");
            try {
                x = scanner.nextInt();
                if (x >= 1 && x <= 1_000_000) {
                    break;
                } else {
                    System.out.println("Valor inválido. Informe um inteiro entre 1 e 1.000.000.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine(); 
            }
        }

        int passos = calcularPassosMinimos(x);
        System.out.println(formatarSaida(passos));

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
