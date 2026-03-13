import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posi\u00E7\u00E3o da casa do amigo: ");
        int posicao = scanner.nextInt();

        int passos = calcularPassosMinimos(posicao);
        System.out.println(formatarSaida(passos));
    }

    public static int calcularPassosMinimos(int x) {
        if (x < 1 || x > 1_000_000) {
            throw new IllegalArgumentException("A posi\u00E7\u00E3o deve estar entre 1 e 1.000.000.");
        }

        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return "O n\u00FAmero m\u00EDnimo de passos necess\u00E1rios \u00E9: " + passos;
    }
}
