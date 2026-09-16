import java.util.Scanner;

public class MaiorNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int maior = a;
        if (b > maior) {
            maior = b;
        }
        if (c > maior) {
            maior = c;
        }

        // Conta quantas vezes o maior valor aparece
        int ocorrencias = 0;
        if (a == maior) ocorrencias++;
        if (b == maior) ocorrencias++;
        if (c == maior) ocorrencias++;

        // Exibe o resultado com base nas ocorrências
        if (ocorrencias > 1) {
            System.out.println("Maior: " + maior + " — EMPATE NO MAIOR VALOR");
        } else {
            System.out.println("Maior: " + maior);
        }

        scanner.close();
    }
}