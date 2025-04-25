import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int posicaoAmigo = scanner.nextInt();
        scanner.close();

        if (posicaoAmigo < 1 || posicaoAmigo > 1000000) {
            System.out.println("Posição inválida. Digite um valor entre 1 e 1000000.");
            return;
        }

        int passosMinimos = calcularPassosMinimos(posicaoAmigo);
        String saidaFormatada = formatarSaida(passosMinimos);
        System.out.println(saidaFormatada);
    }

    public static int calcularPassosMinimos(int x) {
        return (int) Math.ceil((double) x / 5);
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}