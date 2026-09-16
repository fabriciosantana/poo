import java.util.Scanner;

public class AnaliseAlgarismos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("VALOR INVALIDO");
        } else if (numero == 0) {
            System.out.println("Algarismos: 1 — Soma: 0");
        } else {
            int temp = numero;
            int quantidade = 0;
            int soma = 0;

            while (temp > 0) {
                soma += temp % 10;
                quantidade++;
                temp /= 10;
            }

            System.out.println("Algarismos: " + quantidade + " — Soma: " + soma);
        }

        scanner.close();
    }
}