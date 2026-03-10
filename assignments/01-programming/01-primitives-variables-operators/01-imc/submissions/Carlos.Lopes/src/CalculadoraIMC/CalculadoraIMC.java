
import java.util.Scanner;
public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu Peso em Quilogramas(KG):" );
        double peso = teclado.nextDouble();

        System.out.println("Digite sua Altura em Metros(M):");
        double altura = teclado.nextDouble();

        // calcula e apresenta classificação
        double IMC = calcularIMC(peso, altura);
        classificarIMC(IMC);
        
    }

    public static double calcularIMC(double peso, double altura){
        double IMC = peso / (altura * altura);
        return IMC;
    }
    
    public static void classificarIMC(double IMC){ 

    if (IMC < 18.50){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Abaixo do Peso");
    } else
    if (IMC >= 18.50 && IMC < 24.99){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Eutrófico");
    } else
    if(IMC >= 25.0 && IMC < 29.99){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Sobrepeso");
    } else
    if(IMC >= 30.0 && IMC < 34.99){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Obesidade grau I");
    } else
    if(IMC >= 35.0 && IMC < 39.99){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Obesidade grau II");
    } else
    if(IMC >= 40.0){
        System.out.printf("Seu IMC é: %.2f \n", IMC);
        System.out.println("Classificação: Obesidade grau III");
    }
  
    }

}
/*
* Abaixo do peso: IMC < 18.50
* Eutrófico: 18.5 ≤ IMC < 24.99
* Sobrepeso: 25.0 ≤ IMC < 29.99
* Obesidade grau I: 30.0 ≤ IMC < 34.99
* Obesidade grau II: 35.0 ≤ IMC < 39.99
* Obesidade grau III: IMC ≥ 40.0


*/



