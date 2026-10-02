import java.util.Locale;
import java.util.Scanner;

public class AprovacaoEstudante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double primeiraNota = scanner.nextDouble();
        double segundaNota = scanner.nextDouble();

        boolean notasValidas = primeiraNota >= 0 && primeiraNota <= 10
                && segundaNota >= 0 && segundaNota <= 10;

        if (!notasValidas) {
            System.out.println("NOTA INVALIDA");
        } else {
            double media = (primeiraNota + segundaNota) / 2;
            String situacao;

            if (media >= 7) {
                situacao = "APROVADO";
            } else if (media >= 5 && media < 7) {
                situacao = "RECUPERACAO";
            } else {
                situacao = "REPROVADO";
            }

            System.out.println("Média: " + media + " \u2014 " + situacao);
        }

        scanner.close();
    }
}
