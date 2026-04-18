import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        int passos = calcularPassosMinimos(x);

        System.out.println(formatarSaida(passos));

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {

        if (x < 1 || x > 1_000_000) {
            throw new IllegalArgumentException("A posição deve estar entre 1 e 1.000.000.");
        }

        if (x % 5 == 0) {
            return x / 5;
        } else {
            return (x / 5) + 1;
        }
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}