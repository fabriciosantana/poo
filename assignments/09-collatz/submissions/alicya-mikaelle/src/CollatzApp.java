import java.util.Scanner;

class CollatzSequence {

    
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        System.out.print("Sequência de Collatz: ");
        
        while (n != 1) {
            System.out.print(n + " → ");
            sum += n;
            n = nextCollatz(n);
        }
        
        
        System.out.println("1");
        sum += 1;
        return sum;
    }
}

public class CollatzApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            int soma = CollatzSequence.calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + soma);
        }
    }
}

