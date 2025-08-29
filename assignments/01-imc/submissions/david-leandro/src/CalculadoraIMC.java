import java.util.Scanner;

public class CalculadoraIMC {

    // método main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada do usuário
        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        // cálculo do IMC
        double imc = calcularIMC(peso, altura);

        // classificação
        String classificacao = classificarIMC(imc);

        // saída
        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }

    // método que calcula o IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // método que classifica o IMC
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.99) {
            return "Eutrófico";
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
