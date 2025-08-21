import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        if (x >= 1 && x <= 1000000) {
            int passos = calcularPassosMinimos(x);
            String saida = formatarSaida(passos);
            System.out.println(saida);
        }

        input.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (int) Math.ceil((double) x / 5.0);
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}