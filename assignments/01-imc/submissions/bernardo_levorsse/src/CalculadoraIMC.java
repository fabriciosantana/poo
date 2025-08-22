import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas (Ex: 80): ");
        double peso = lerDouble(scanner);

        System.out.print("Digite sua altura em metros (Ex: 1.85): ");
        double altura = lerDouble(scanner);

        double imc = calcularIMC(peso, altura);

        String classificacao = classificarIMC(imc);

        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }

    private static double lerDouble(Scanner scanner) {
        String valorStr = scanner.nextLine().trim().replace(',', '.');
        while (valorStr.isEmpty()) {
            valorStr = scanner.nextLine().trim().replace(',', '.');
        }
        return Double.parseDouble(valorStr);
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
