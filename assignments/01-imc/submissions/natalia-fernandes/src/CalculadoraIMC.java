import java.util.Scanner;

public class CalculadoraIMC {
    
public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
System.out.print("Digite seu peso: ");
        double peso = entrada.nextDouble();
        
System.out.print("Digite sua altura: ");
        double altura = entrada.nextDouble();
     
double imc = calcularIMC(peso, altura);
       
String classificacao = classificarIMC(imc);
    
        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: " + classificacao);
        entrada.close();
    }
    
    // Método para calcular o IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método para classificar o IMC
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
