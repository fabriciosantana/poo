import java.util.Scanner;

public class CollatzSequence{
    public static int nextCollatz(int n){
        if(n % 2 == 0){
            return n / 2;
        } else{
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n){
        int total = n;
        System.out.print("Sequência de Collatz: " + n);
        while(n != 1){
            n = nextCollatz(n);
            System.out.print(" -> " + n);
            total += n;
        }

        System.out.println();
        return total;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int num = scanner.nextInt();
        if(num < 1){
            System.out.println("Erro: o número deve ser um inteiro positivo");
            scanner.close();
            return;
        }

        int soma = calculateCollatzSum(num);
        System.out.println("Soma dos termos: " + soma);
        scanner.close();
    }
}