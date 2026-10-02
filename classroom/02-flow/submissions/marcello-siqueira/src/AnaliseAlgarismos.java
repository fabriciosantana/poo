import java.util.Scanner;

public class AnaliseAlgarismos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            int restante = numero;
            int quantidade = 0;
            int soma = 0;

            while (restante > 0) {
                soma += restante % 10;
                quantidade++;
                restante /= 10;
            }

            // o laco nao roda para 0, mas 0 tem um algarismo
            if (numero == 0) {
                quantidade = 1;
            }

            System.out.println("Algarismos: " + quantidade + " \u2014 Soma: " + soma);
        }

        scanner.close();
    }
}
