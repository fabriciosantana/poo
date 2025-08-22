import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        scanner.close();

        int passos = calcularPassosMinimos(x);
        String saidaFormatada = formatarSaida(passos);

        System.out.println(saidaFormatada);
    }

    public static int calcularPassosMinimos(int x) {
        // Para minimizar os passos, o elefante deve usar o maior passo possível (5).
        // A quantidade de passos é a distância total dividida pelo maior passo,
        // arredondada para cima (função teto).
        // Em aritmética inteira, ceil(x / 5) é equivalente a (x + 4) / 5.
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}