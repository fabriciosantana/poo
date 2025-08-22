import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        if (x < 1 || x > 1000000) {
            System.out.println("Valor inválido. O valor deve estar entre 1 e 1.000.000.");
        } else {
            int passos = calcularPassosMinimos(x);
            String saida = formatarSaida(passos);
            System.out.println(saida);
        }
        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5; 
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
