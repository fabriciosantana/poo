
import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = input.nextDouble();
        input.nextLine();

        System.out.print("Digite sua altura em metros: ");
        double altura = input.nextDouble();

        double imc = calcularIMC(peso, altura);
        System.out.printf("Seu IMC é: %.2f%n", imc);

        String classificacao = classificarIMC(imc);
        System.out.printf("Classificação: %s%n", classificacao);
        
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5)
            return "Abaixo do peso";
        else if (imc < 24.99)
            return "Eutrófico";
        else if (imc < 29.99)
            return "Sobrepeso";
        else if (imc < 34.99)
            return "Obesidade grau I";
        else if (imc < 39.99)
            return "Obesidade grau II";
        else
            return "Obesidade grau III";
    }

}
