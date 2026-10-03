import java.util.Scanner;

public class DivisaoApp{
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            char continuar = 's';

            while(continuar == 's' || continuar == 'S'){
            System.out.printf("Digite o primeiro número: \n");
            int num1 = scanner.nextInt();
            System.out.printf("Digite o segundo número: \n");
            int num2 = scanner.nextInt();

            int resultado = 0;
            try{
                resultado = num1 / num2;
                System.out.println("Resultado da divisão: " + resultado);
            } catch (ArithmeticException e){
                System.out.println("DENOMINADOR INVALIDO");
            }

            System.out.println("Deseja realizar outra divisão? (s/n)");
            continuar = scanner.next().charAt(0);
            }
        }
    }
}
