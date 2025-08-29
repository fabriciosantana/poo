import java.util.Scanner;

public class PassosElefante {

    public static int calcularPassosMinimos(int x) {
        if (x < 1 || x > 1000000) {
            throw new IllegalArgumentException("A posição x deve estar entre 1 e 1.000.000.");
        }
        int passos = 0;
        passos += x / 5;
        x %= 5;
        passos += x / 4;
        x %= 4;
        passos += x / 3;
        x %= 3;
        passos += x / 2;
        x %= 2;
        passos += x / 1;
        return passos;
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        try {
            int x = scanner.nextInt();
            int passos = calcularPassosMinimos(x);
            String saida = formatarSaida(passos);
            System.out.println(saida);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro positivo.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
