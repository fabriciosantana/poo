import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu peso em quilogramas:");
        double peso = scanner.nextDouble();

        System.out.println("Digite sua altura em metros:");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);

        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("Classificação: "+classificarIMC(imc));

        scanner.close();

    }

    public static double calcularIMC(double peso, double altura){
        return peso / Math.pow(altura, 2);
    }

    public static String classificarIMC(double imc){
        if(imc < 18.5){
            return "Abaixo do peso";
        }
        else if(imc < 24.99){
            return "Eutrófico";
        }
        else if(imc < 29.99){
            return "Sobrepeso";
        }
        else if(imc < 34.99){
            return "Obesidade grau I";
        }
        else if(imc < 39.99){
            return "Obesidade grau II";
        }
        else if(imc >= 40.0){
            return "Obesidade grau III";
        }
                return null;
    }
    
}
