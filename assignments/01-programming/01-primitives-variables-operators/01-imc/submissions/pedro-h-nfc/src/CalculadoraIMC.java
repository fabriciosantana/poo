import java.util.Locale;
import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);

        System.out.println(String.format(Locale.US, "Seu IMC \u00E9: %.2f", imc));
        System.out.println("Classifica\u00E7\u00E3o: " + classificarIMC(imc));
    }

    public static double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser positivos.");
        }

        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        }
        if (imc < 25.0) {
            return "Eutr\u00F3fico";
        }
        if (imc < 30.0) {
            return "Sobrepeso";
        }
        if (imc < 35.0) {
            return "Obesidade grau I";
        }
        if (imc < 40.0) {
            return "Obesidade grau II";
        }
        return "Obesidade grau III";
    }
}
