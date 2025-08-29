import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite a posição da casa do amigo: ");
        
        int x = scanner.nextInt();
        int passos = calcularPassosMinimos(x);

        String saida = formatarSaida(passos);

        System.out.println(saida);

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}
