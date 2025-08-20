import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[]args){
        
        Scanner scanner = new Scanner(System.in);  //CRIA SCANNER

        System.out.print("Digite seu peso em quilogramas: "); //SCANNER PESO
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: "); //SCANNER ALTURA
        double altura = scanner.nextDouble();


        double imc = calcularIMC(peso, altura); //DECLARANDO FUNÇÃO DE CALCULO DE IMC
        String classificacao = classificarIMC(imc); //DECLARANDO FUNÇÃO DE CLASSFICAÇÃO DE IMC
        

        System.out.printf("Seu IMC é: %.2f%n", imc); 
        System.out.println("Classificação: " + classificacao);  //PRINTS    

        scanner.close();
    }

    public static double calcularIMC (double peso, double altura){  //FUNÇÃO CÁLCULO

        return peso / (altura*altura);
    }

    public static String classificarIMC (double imc){  //FUNÇÃO CLASSIFICAÇÃO

        if (imc < 18.50){
            return "Abaixo do peso";

        } else if (imc < 24.99) {
            return "Eutrófico";

        } else if (imc < 29.99){
            return "Sobrepeso";

        } else if (imc < 34.99){
            return "Obesidade grau I";

        } else if (imc < 39.99){
            return "Obesidade grau II";

        } else {
            return "Obesidade grau III";
        }
    }

}
    
