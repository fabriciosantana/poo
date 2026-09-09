import java.util.Scanner;

public class PadraoRetangular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linhas = scanner.nextInt();
        int colunas = scanner.nextInt();

        if (linhas <= 0 || colunas <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    System.out.print("*" + (j == colunas - 1 ? "" : " "));
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}