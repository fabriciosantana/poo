import java.util.Scanner;

public class MaiorEntreTres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int primeiro = scanner.nextInt();
        int segundo = scanner.nextInt();
        int terceiro = scanner.nextInt();

        int maior;
        if (primeiro >= segundo && primeiro >= terceiro) {
            maior = primeiro;
        } else if (segundo >= primeiro && segundo >= terceiro) {
            maior = segundo;
        } else {
            maior = terceiro;
        }

        boolean empateNoMaior = (primeiro == maior && segundo == maior)
                || (primeiro == maior && terceiro == maior)
                || (segundo == maior && terceiro == maior);

        if (empateNoMaior) {
            System.out.println("Maior: " + maior + " \u2014 EMPATE NO MAIOR VALOR");
        } else {
            System.out.println("Maior: " + maior);
        }

        scanner.close();
    }
}
