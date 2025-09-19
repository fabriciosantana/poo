import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int n = sc.nextInt();

        if(n < 1){
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {

            System.out.print("Sequência de Collatz: ");
            
            while (n != 1) {
            System.out.print(n + " → ");
            n = nextCollatz(n);
            }
            
            System.out.println("1");

            int somaCollatz = calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + somaCollatz);
        }
        sc.close();
    }

public static int nextCollatz(int n){
    if (n % 2 == 0) return n / 2;
    else return (n * 3) + 1;
}

public static int calculateCollatzSum(int n){
    int soma = 0;
    while(n != 1){
        soma += n;
        n = nextCollatz(n);
    }
    soma += 1;
    return soma; 
    }
}