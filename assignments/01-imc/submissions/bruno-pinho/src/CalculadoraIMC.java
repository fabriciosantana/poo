import java.util.Scanner;
import java.util.Locale;

public class CalculadoraIMC {

    public static void main(String[] args) {
        // Define o local para US para garantir que o separador decimal seja o ponto (.)
        Locale.setDefault(Locale.US);
        Scanner leitorDeEntrada = new Scanner(System.in);

        System.out.println("--- Calculadora de Índice de Massa Corporal ---");

        System.out.print("Olá! Para começar, por favor, digite seu peso em quilogramas (ex: 75.5): ");
        double peso = leitorDeEntrada.nextDouble();

        System.out.print("Obrigado! Agora, digite sua altura em metros (ex: 1.80): ");
        double altura = leitorDeEntrada.nextDouble();

        leitorDeEntrada.close();

        double indiceDeMassaCorporal = calcularIMC(peso, altura);
        String resultadoDaClassificacao = classificarIMC(indiceDeMassaCorporal);

        System.out.println("\n--- Resultado ---");
        // Usamos printf para formatar o número com duas casas decimais
        System.out.printf("Seu IMC é de: %.2f\n", indiceDeMassaCorporal);
        System.out.println("Sua classificação é: " + resultadoDaClassificacao);
    }

    /**
     * Calcula o valor do IMC usando a fórmula: peso / (altura * altura).
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Retorna a classificação do IMC de acordo com a tabela do Ministério da Saúde.
     */
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.99) {
            return "Eutrófico (Peso ideal)";
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