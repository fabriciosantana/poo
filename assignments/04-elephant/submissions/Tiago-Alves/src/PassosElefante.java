
import java.util.Scanner;

class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        System.out.println(formatarSaida(calcularPassosMinimos(x)));
        scanner.close();
    }
    public static int calcularPassosMinimos(int x)
    {
        return (x + 4) / 5;
    }
    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}