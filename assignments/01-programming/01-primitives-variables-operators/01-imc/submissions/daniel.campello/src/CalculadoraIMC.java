import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);

        System.out.printf("Seu IMC \u00e9: %.2f%n", imc);
        System.out.println("Classifica\u00e7\u00e3o: " + classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.99) {
            return "Eutr\u00f3fico";
        } else if (imc < 29.99) {
            return "Sobrepeso";
        } else if (imc < 34.99) {
            return "Obesidade grau I";
        } else if (imc < 39.99) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}
