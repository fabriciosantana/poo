import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        int collatz = n;
        if(collatz % 2 == 0){
            return collatz = collatz / 2;

        }else{
            return collatz = (collatz * 3) + 1;
            
        }
    }

    public static int calculateCollatzSum(int n) {
        int soma = n, collatz = n;
        if(collatz != 1)
            System.out.printf("%d -> ", collatz);

        while(collatz != 1){
            collatz = nextCollatz(collatz);

            if(collatz == 1) { 
                System.out.printf("1%n", collatz);

            }else{
                System.out.printf("%d -> ", collatz); 

            } 
            soma += collatz;
        }
        return soma;
    }

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        System.out.printf("Digite um número inteiro positivo: ");
        int numero = ler.nextInt();

        while (numero <= 0){
            System.out.printf("Erro: O número deve ser um inteiro positivo.%n");
            System.out.printf("Digite um número inteiro positivo: ");
            numero = ler.nextInt();
        }

        System.out.printf("%nSequência de Collatz: %d", nextCollatz(numero));
        System.out.printf("Soma dos termos: %d", calculateCollatzSum(numero));

    }
}
