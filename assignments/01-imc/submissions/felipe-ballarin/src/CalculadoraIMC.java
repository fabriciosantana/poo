import java.util.Scanner;

public class CalculadoraIMC {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu peso em quilogramas:");
        double peso = scanner.nextDouble();
        
        System.out.println("Digite sua altura em metros:");
        double altura = scanner.nextDouble();
        
        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);
        
        System.out.println("\nSeu IMC é:");
        System.out.printf("%.2f%n%n", imc);
        System.out.println("Classificação:");
        System.out.println(classificacao);
        
        scanner.close();
    }
    
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    public static String classificarIMC(double imc) {
        if (imc < 18.50) {
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
