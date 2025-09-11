import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int position = scanner.nextInt();
        scanner.close();

        int minSteps = calcularPassosMinimos(position);
        System.out.println(formatarSaida(minSteps));
    }

    public static int calcularPassosMinimos (int position) {
        int completeSteps = position / 5;

        if (position % 5 != 0) completeSteps++;

        return  completeSteps;
    }
    public static String formatarSaida(int steps) {
        return String.format("O número mínimo de passos necessários é: %d", steps);
    }
}