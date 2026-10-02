import java.util.Locale;
import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // entrada nao numerica vira 0; isFinite barra NaN e Infinity, que o Scanner aceita
        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.hasNextDouble() ? scanner.nextDouble() : 0;
        if (!Double.isFinite(peso) || peso <= 0) {
            System.out.println("Peso inválido: informe um número maior que zero.");
            scanner.close();
            return;
        }

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.hasNextDouble() ? scanner.nextDouble() : 0;
        if (!Double.isFinite(altura) || altura <= 0) {
            System.out.println("Altura inválida: informe um número maior que zero.");
            scanner.close();
            return;
        }
        scanner.close();

        double imc = calcularIMC(peso, altura);
        System.out.printf(Locale.US, "Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificarIMC(imc));
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        // o README deixa buracos (24.99 a 25.0 etc.); limites com < 25.0, < 30.0... cobrem todo valor
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25.0) {
            return "Eutrófico";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else if (imc < 35.0) {
            return "Obesidade grau I";
        } else if (imc < 40.0) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}
