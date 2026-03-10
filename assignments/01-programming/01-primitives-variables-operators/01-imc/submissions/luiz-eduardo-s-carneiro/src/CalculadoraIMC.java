import java.util.Scanner;

public class CalculadoraIMC{

    public static double calcularIMC(double peso, double altura){

        double imc  =  peso / Math.pow(altura, 2);
        return imc;
    }

    public static String classificarIMC(double imc){

        if (imc < 18.50){
            return "Classificação: Abaixo do Peso";
        } else if (18.50 <= imc && imc <= 24.99){
            return "Classificação: Eutrófico";
        } else if (25.00 <= imc && imc <= 29.99){
            return "Classificação: Sobrepeso";
        } else if (30.00 <= imc && imc <= 34.99){
            return "Classificação: Obesidade gau I";
        } else if (35.00 <= imc && imc <= 39.99){
            return "Classificação: Obesidade gau II";
        } else {
            return "Classificação: Obesidade gau III";
        }
    }

    public static void main(String[] Args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        System.out.printf("Digite a sua altura em metros: ");
        double altura = scanner.nextDouble();
        
        double imc = calcularIMC(peso, altura);
        
        System.out.printf("Seu IMC é: %.2f\n", imc);
        System.out.println(classificarIMC(imc));
    }

}