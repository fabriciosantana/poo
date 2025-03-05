import java.util.Scanner;

public class PassosElefante {
    public static int calcularPassosMinimos (int x) {
        if (1 <= x & x <= 5)
            return 1;
        else if (x % 5 == 0)
            return x / 5;
        else return x / 5 + 1;
    }
    public static String formatarSaida (int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        if (x < 1 || x > 1000000) {
            scanner.close();
            throw new java.lang.Error("Posição do elefante inválida");
        }
        int passos = calcularPassosMinimos(x);
        System.out.println(formatarSaida(passos));
        scanner.close();
    }
}
