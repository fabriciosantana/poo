import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite seu peso em quilogramas: "); // entrada

        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura); // calculo

        String classificacao = classificarIMC(imc); // classifica

        System.out.printf("Seu IMC é: %.2f%n", imc); // mostrando resultado
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
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
