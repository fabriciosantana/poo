package Lucas_Pontual.src.elephant;

import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Erro: A posição deve ser um inteiro positivo entre 1 e 1.000.000.");
        } else {
            int passos = calcularPassosMinimos(x);
            System.out.println(formatarSaida(passos));
        }

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
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
}


