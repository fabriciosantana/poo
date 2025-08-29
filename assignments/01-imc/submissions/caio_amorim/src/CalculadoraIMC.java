import java.util.Scanner;

public class CalculadoraIMC {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite seu peso em quilogramas: ");
        String pesoStr = scanner.nextLine().replace(",", ".");
        double peso = Double.parseDouble(pesoStr);
        
        System.out.print("Digite sua altura em metros: ");
        String alturaStr = scanner.nextLine().replace(",", ".");
        double altura = Double.parseDouble(alturaStr);
        
        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);
        
        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificacao);
        
        scanner.close();
    }
    
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc <= 24.9) {
            return "Eutrófico (peso normal)";
        } else if (imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc <= 34.9) {
            return "Obesidade grau I";
        } else if (imc <= 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}
