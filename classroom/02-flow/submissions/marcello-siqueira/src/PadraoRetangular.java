import java.util.Scanner;

public class PadraoRetangular {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linhas = scanner.nextInt();
        int colunas = scanner.nextInt();

        if (linhas <= 0 || colunas <= 0) {
            System.out.println("DIMENSAO INVALIDA");
        } else {
            for (int linha = 1; linha <= linhas; linha++) {
                for (int coluna = 1; coluna <= colunas; coluna++) {
                    if (coluna > 1) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
