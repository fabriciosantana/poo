import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("A posição deve estar entre 1 e 1.000.000.");
            scanner.close();
            return;
        }

        int passosMinimos = calcularPassosMinimos(x);
        String saidaFormatada = formatarSaida(passosMinimos);

        System.out.println(saidaFormatada);

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        int passos = x / 5;
        if (x % 5 != 0) {
            passos++;
        }
        return passos;
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}


