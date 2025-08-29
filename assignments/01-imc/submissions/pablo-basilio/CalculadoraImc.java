import java.util.Scanner;

public class CalculadoraImc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double weight = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double height = scanner.nextDouble();

        scanner.close();

        double imc = CalculadoraImc(weight, height);
        String classification = classificarIMC(imc);

        System.out.printf("Seu IMC é: %.2f\n", imc);
        System.out.println("Classificação: " + classification);
    }

    public static double CalculadoraImc(double weight, double height) {
        return weight / (height * height);
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