import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your weight in kg:");
        double peso = scanner.nextDouble();

        System.out.println("Input your height in meters:'x.xx'");
        double altura = scanner.nextDouble();

        scanner.close();

        double imc = calcularIMC(peso, altura);
        String classification = classificarIMC(imc);

        System.out.printf("Your IMC is: %.2f\n", imc);
        System.out.println("Classification: " + classification);
    }
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

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