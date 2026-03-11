import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double IMC = calcularIMC(peso, altura);
        String classificacao = classificarIMC(IMC);

        System.out.printf("Seu IMC é: %.2f\n", IMC);
        System.out.printf("Classificação: %s", classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura){
        return peso / (altura * altura);
    }

    public static String classificarIMC(double IMC){
        if (IMC < 18.5){
            return "Abaixo do peso";
        }
        else if (18.5 <= IMC && IMC <= 24.99){
            return "Eutrófico";
        }
        else if (25 <= IMC && IMC <= 29.99){
            return "Sobrepeso";
        }
        else if (30 <= IMC && IMC <= 34.99){
            return "Obesidade grau I";
        }
        else if (35 <= IMC && IMC <= 39.99){
            return "Obesidade grau II";
        }
        else if (IMC >=40){
            return "Obesidade grau III";
        }
        return "Informações incorretas.";
    }

}