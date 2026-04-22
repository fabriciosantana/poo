import java.util.Scanner;
//02-04
public class CollatzSequence{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = 0;

        do{
           System.out.println("Digite um Numero Inteiro Positivo: ");
           n = scanner.nextInt();
           if( n < 1){
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
          }
        } while ( n < 1);


        // Apresenta os resultados para o usuário
        int atual = n;
        System.out.print("Sequência de Collatz: " );
        while ( atual != 1){
            System.out.print(atual + " → ");
            atual = nextCollatz(atual);
        }
        System.out.println("1");

        int soma =  calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + soma);
        
    }

    public static int nextCollatz(int n){
         // Retorna o próximo número da sequência
        //Numero Par e Numero Impar
        if ( n % 2 == 0){
            return n / 2; //Numero Par
        } else {
            return (3 * n) + 1; //Numero Impar
        }
    }

    public static int calculateCollatzSum(int n){
        int soma = 0;
        while ( n !=1) {
            if ( n % 2 == 0){
            n = (n / 2);
        } else {
            n = (3 * n + 1);
        }
        soma += n;
       }
    return soma;
    }



}