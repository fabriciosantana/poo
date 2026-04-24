import java.util.Scanner;

public class CalculadoraIMC {
    
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.50) {
            return "Abaixo do peso";
        } else if (imc >= 18.50 && imc < 24.99) {
            return "Eutrófico";
        } else if (imc >= 25.00 && imc < 29.99) {
            return "Sobrepeso";
        } else if (imc >= 30.00 && imc < 34.99) {
            return "Obesidade grau I";
        } else if (imc >= 35.00 && imc < 39.99) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o peso em quilogramas: ");
        double peso = input.nextDouble();
        System.out.print("Digite a altura em metros: ");
        double altura = input.nextDouble();
        
        double imc = calcularIMC(peso, altura);
        String imcFormatado = String.format("%.2f", imc);
        System.out.println("Seu IMC é: " + imcFormatado);

        String classificacao = classificarIMC(imc);
        System.out.println("Classificação: " + classificacao);
    }

}