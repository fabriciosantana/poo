import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada nao numerica vira 0 e cai na mesma validacao de intervalo
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.close();
        if (x < 1 || x > 1_000_000) {
            System.out.println("A posição deve estar entre 1 e 1.000.000.");
            return;
        }

        System.out.println(formatarSaida(calcularPassosMinimos(x)));
    }

    public static int calcularPassosMinimos(int x) {
        // passos de 5 sempre que possivel; o resto, se houver, custa mais um passo
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}
