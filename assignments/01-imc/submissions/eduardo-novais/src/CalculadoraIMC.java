import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        double weight, height, IMC;
        String classificação;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu peso: ");  
        weight = input.nextDouble();

        System.out.print("Digite sua altura: ");
        height = input.nextDouble();

        IMC = calcularIMC(weight, height);

        classificação = classificarIMC(IMC);

        String.format("\nSeu IMC é: %.2f \nClassificação: %s!\n", IMC, classificação);
    }

    public static double calcularIMC(double weight, double height) {
        return weight / ( height * height);
    }

    public static String classificarIMC(double IMC) {
        if (IMC < 18.5) {
            return String.format("Abaixo do peso" );
        } else if (IMC >= 18.5 && IMC < 24.99) {
            return String.format("Eutrófico" );
        } else if (IMC >= 25 && IMC < 29.99) {
            return String.format("Sobrepeso");
        } else if (IMC >= 30 && IMC < 34.99) {
            return String.format("Obesidade grau I");
        } else if (IMC >= 35 && IMC < 39.99) {
            return String.format("Obesidade grau II");
        } else {
            return String.format("Obesidade grau III");
        }
    }
}