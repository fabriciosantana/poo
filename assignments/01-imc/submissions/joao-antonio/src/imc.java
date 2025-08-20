import java.util.Scanner;

public class CalculadoraIMC {

    // Método para calcular o IMC
    public static double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            return 0; // valor inválido
        }
        return peso / (altura * altura);
    }

    // Método para classificar o IMC de acordo com o Ministério da Saúde
    public static String classificarIMC(double imc) {
        if (imc <= 0) {
            return "Valores inválidos para peso ou altura.";
        } else if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25.0) {
            return "Eutrófico";
        } else if (imc >= 25.0 && imc < 30.0) {
            return "Sobrepeso";
        } else if (imc >= 30.0 && imc < 35.0) {
            return "Obesidade grau I";
        } else if (imc >= 35.0 && imc < 40.0) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);

        if (imc > 0) {
            System.out.printf("Seu IMC é: %.2f%n", imc);
        }
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }
}
