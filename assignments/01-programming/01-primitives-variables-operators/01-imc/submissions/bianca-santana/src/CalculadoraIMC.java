import java.util.Scanner;

public class CalculadoraIMC {
        
    public static double calcularIMC(double peso, double altura){
        double imc = peso/(altura*altura);
        return imc;

    }

    public static String classificarIMC(double imc){
        String cls; 
        if (imc < 18.5) {
        cls = "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.99) {
            cls = "Eutrófico";
        } else if (imc >= 25.0 && imc <= 29.99) {
            cls = "Sobrepeso";
        } else if (imc >= 30.0 && imc <= 34.99) {
            cls = "Obesidade grau I";
        } else if (imc >= 35.0 && imc <= 39.99) {
            cls = "Obesidade grau II";
        } else {
            cls = "Obesidade grau III"; 
        }
        return cls;
    }
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = ler.nextDouble();
        
        System.out.print("Digite sua altura em metros: ");
        double altura = ler.nextDouble();

        double imc = calcularIMC(peso, altura);
        String cls = classificarIMC(imc);
        
        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.printf("Classificação: %s", cls );

        }

    }

