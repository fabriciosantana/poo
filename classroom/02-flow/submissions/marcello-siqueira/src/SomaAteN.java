import java.util.Scanner;

public class SomaAteN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limite = scanner.nextInt();

        if (limite <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            // long evita estouro da soma e do contador quando N chega perto de Integer.MAX_VALUE
            long soma = 0;
            for (long numero = 1; numero <= limite; numero++) {
                soma += numero;
            }
            System.out.println(soma);
        }

        scanner.close();
    }
}
