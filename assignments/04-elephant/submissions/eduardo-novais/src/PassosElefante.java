import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        int steps;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Número inválido! Digite um valor entre 1 e 1.000.000.");
            return;
        }

        steps = calcularPassosMinimos(x);

        System.out.println(formatarSaida(steps));
    }

    public static int calcularPassosMinimos(int x) {
        int steps = x / 5;

        if (x % 5 != 0) {
            steps += 1;
        }

        return steps;
    }

    public static String formatarSaida(int steps) {
        return String.format("O número mínimo de passos necessários é: %d", steps);
    }
}
