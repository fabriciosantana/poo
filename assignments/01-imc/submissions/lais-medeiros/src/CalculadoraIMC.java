import java.util.Scanner;

public class CalculadoraIMC {

    // Método para calcular o IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método para classificar o IMC
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
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

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o peso em kg: ");
        double peso = leitor.nextDouble();

        System.out.print("Digite a altura em metros (ex: 0.00):  ");
        double altura = leitor.nextDouble();

        double imc = calcularIMC(peso, altura);

        String classificacao = classificarIMC(imc);

        System.out.println("Seu IMC é: " + imc);
        System.out.println("Classificação: " + classificacao);

        leitor.close();
    }
}