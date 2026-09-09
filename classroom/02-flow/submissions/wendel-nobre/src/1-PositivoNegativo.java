import java.util.Scanner;

class PositivoNegativo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Digite um numero inteiro: ");

            int numero = input.nextInt();    
            if (numero > 0){
                System.out.println("Positivo"); 
            } else if (numero < 0) {
                System.out.println("Negativo");
            } else {
                System.out.println("Zero");
            }
        }
    }
}

