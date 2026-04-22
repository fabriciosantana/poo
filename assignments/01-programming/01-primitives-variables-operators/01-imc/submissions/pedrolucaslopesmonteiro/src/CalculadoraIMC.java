import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe o seu peso: ");
        double peso = input.nextDouble();
        System.out.printf("Peso do usuário: %.2f%n", peso);

        System.out.println("Infome sua altura: ");
        double altura = input.nextDouble();
        System.out.printf("Altura do usuário: %.2f%n", altura);
        
        double imc = calcularIMC(peso,altura);
        System.out.println(classificarIMC(imc));
        
        System.out.printf("Seu imc é: %.2f%n",imc);
     }

     public static double calcularIMC(double peso, double altura ) {
        return peso / (altura * altura);
     }

     public static String classificarIMC(double imc) { // metodo promete retornar uma String , por isso deve ter um return
      if (imc< 18.5) {
        return("Classificação: Abaixo do peso");
      } else if(imc<24.99) {
         return("Classificação: Eutrófico");
      } else if (imc<29.99) {
         return("Classificação: Sobrepeso");
      } else if(imc<34.99) {
         return("Classificação: Obesidade de Grau I");
      } else if (imc<40) {
         return("Classificação: Obesidade de Grau II");
      } else {
         return("Classificação: Obesidade de Grau III");
      } 
      
     }
}