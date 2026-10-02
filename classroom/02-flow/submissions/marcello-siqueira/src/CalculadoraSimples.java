import java.util.Locale;
import java.util.Scanner;

public class CalculadoraSimples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double primeiroNumero = scanner.nextDouble();
        String operador = scanner.next();
        double segundoNumero = scanner.nextDouble();

        String resultado = switch (operador) {
            case "+" -> String.valueOf(primeiroNumero + segundoNumero);
            case "-" -> String.valueOf(primeiroNumero - segundoNumero);
            case "*" -> String.valueOf(primeiroNumero * segundoNumero);
            case "/" -> {
                if (segundoNumero == 0) {
                    yield "DIVISAO POR ZERO";
                }
                yield String.valueOf(primeiroNumero / segundoNumero);
            }
            default -> "OPERADOR INVALIDO";
        };

        System.out.println(resultado);

        scanner.close();
    }
}
