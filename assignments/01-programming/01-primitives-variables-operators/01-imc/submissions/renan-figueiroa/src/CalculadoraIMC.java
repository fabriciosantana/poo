import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        
        System.out.println("Digite o seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        System.out.println();

        System.out.println("Digite a sua altura em metros: ");
        double altura = scanner.nextDouble();
        System.out.println();
    
        double IMC = calcularIMC(peso, altura);
        String Classificacao = classificarIMC(IMC);


        System.out.printf("Seu imc é: %.2f\n", IMC);
        System.out.println("Classificação: " + Classificacao);
    }

    public static double calcularIMC(double peso, double altura){
        double resultado = peso/(altura *altura);
        return resultado;
    }

    public static String classificarIMC(double IMC){
        String classificacao = "Sem classificação";
            if(IMC<18.5){
                classificacao = "Abaixo do peso";
            }else if (18.5 <= IMC &&IMC <24.99) {
                classificacao = "Eutrófico";
            }else if (24.99 <= IMC &&IMC <29.99) {
                classificacao = "Sobrepeso";
            }else if (29.99 <= IMC &&IMC <34.99) {
                classificacao = "Obesidade grau I";
            }else if (18.5 <= IMC &&IMC <39.99){
                classificacao = "Obesidade grau II";
            }else if(39.99 <= IMC &&IMC <40.00){
                classificacao = "Obesidade grau III";
            }


        return classificacao;
    }

}

