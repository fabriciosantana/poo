import java.util.Scanner;

public class CalculadoraIMC {

    public static Double calcularIMC (double peso, double altura) {
        double imc = (float) peso / (altura * altura);
        return imc;
    }

    public static String classificarIMC (double imc) {
        String classificacao;
        if (imc < 18.5f)
            classificacao = "Abaixo do peso";

        else if (18.5f < imc & imc < 24.99f)
            classificacao = "Eutrófico";

        else if (25.0f < imc & imc < 29.99f)
            classificacao = "Sobrepeso";

        else if (30.0f < imc & imc < 34.99f)
            classificacao = "Obesidade grau I";

        else if (35.0f < imc & imc < 39.99f)
            classificacao = "Obesidade grau II";

        else if (imc > 40.0f)
            classificacao = "Obesidade grau III";
        
        else
            classificacao = "Impossível obter a classificação";
        
        return classificacao;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu peso em kilogramas: ");
        double peso = scanner.nextDouble();
        ////System.out.println("Seu peso é: " + peso);

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();
        ////System.out.println("Sua altura é: " + altura);
        
        double imc = calcularIMC(peso, altura);
        
        System.out.println("Seu IMC é: " + imc);
        System.out.print("Classificação: " + classificarIMC(imc));

        scanner.close();
    }
}
