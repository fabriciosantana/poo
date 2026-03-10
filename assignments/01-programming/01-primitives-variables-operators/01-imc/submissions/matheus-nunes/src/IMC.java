import java.util.Scanner;
public class Calculadora de índice de massa corporal (IMC){
    public static void main(String[] agrs){
        Scanner teclado = new Scanner(System.in);
        double peso;
        double altura;
        double imc;
        System.out.print("Digite o seu peso:");
        peso = teclado.nextDouble();
        System.out.print("Digite a sua altura:");
        altura = teclado.nextDouble();

        imc = peso/ (altura * altura);

        System.out.printLN("O seu IMC é: " + imc);
        if (imc < 18.5) {
            System.out.println("Você está abaixo do peso");

        } else if (imc < 25) {
            System.out.println("Você está Eutrófico");

        } else if (imc < 30) {
            System.out.println("Você está com sobrepeso");

        } else if (imc < 35) {
            System.out.println("Você está com obesidade nível 1");

        } else if (imc < 40) {
            System.out.println("Você está com obesidade nível 2");

        } else {
            System.out.println("Você está com obesidade nível 3");
        }
    }
}