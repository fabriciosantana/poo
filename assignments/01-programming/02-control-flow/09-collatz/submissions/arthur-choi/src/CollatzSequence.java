import java.util.Scanner;

public class CollatzSequence {
    
    public static int nextCollatz(int n) {
        int semente = n;
        if(semente % 2 == 0){
            return semente = semente / 2;

        }else{
            return semente = (semente * 3) + 1;
            
        }
    }

    public static int calculateCollatzSum(int n){
        int soma = n, semente = n;
        if(semente != 1){
            System.out.printf("%d -> ", semente);
        }else{
            System.out.printf("1%n");
        }

        while(semente != 1){
            semente = nextCollatz(semente);

            if(semente == 1) { 
                System.out.printf("%d%n", semente);

            }else{
                System.out.printf("%d -> ", semente); 

            } 
            soma += semente;
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        while (numero <= 0){
            System.out.printf("Erro: O número deve ser um inteiro positivo.%n");
            System.out.printf("Digite um número inteiro positivo: ");
            numero = scanner.nextInt();
        }

        System.out.printf("Sequência de Collatz: %d", calculateCollatzSum(numero));

    }

}
