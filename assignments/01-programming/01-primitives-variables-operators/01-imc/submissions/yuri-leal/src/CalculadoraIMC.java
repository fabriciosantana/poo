import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite seu peso em quilogramas: ");
        double peso = input.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = input.nextDouble();
        
        double imcResultado = calcularIMC(peso, altura);
        String imcClassificado = classificarIMC(imcResultado);
        
        System.out.printf("Seu IMC é: %.2f%n", imcResultado);
        System.out.println("Classificação: " + imcClassificado);
    }

    public static double calcularIMC(double peso, double altura){
        double imc = peso / (altura * altura);
        return imc;
    }

    public static String classificarIMC(double imc){
        if (imc < 18.5){
            return "Abaixo do peso";
        }else if (imc >= 18.5 && imc < 24.99){
            return "Eutrófico";
        }else if (imc >= 25 && imc < 29.99){
            return "Sobrepeso";
        }else if (imc >= 30 && imc < 34.99){
            return "Obesidade grau I";
        }else if (imc >= 35 && imc < 39.99){
            return "Obesidade grau II";
        }else if (imc >= 40){
            return "Obesidade grau III";
        }else {
            return "aaaaaaa";
        }
    }
}
