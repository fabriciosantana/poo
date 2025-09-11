import java.util.Scanner;

public class CollatzSequence {
    public static int nextCollatz(int nAtual){
        while(true){
            if(nAtual == 1){
                break;
            }

            if(nAtual % 2 == 0){
                nAtual = nAtual / 2;
                return nAtual;
            }
            else{
                nAtual = (nAtual * 3) + 1;
                return nAtual;
            }
        }
        return nAtual;
    }
    public static int calculateCollatzSum(int n){
        int sum = n;

        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
                sum += n;
            }
            else{
                n = (n * 3) + 1;
                sum += n;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n;

        while(true){
            System.out.print("Digite um número inteiro positivo: ");
            n = scanner.nextInt();

            if(n > 0){
                break;
            }
            else{
                System.out.print("Erro: O número deve ser um inteiro positivo.\n");
            }
        }
        
        int nAtual = n;

        while(nAtual != 1){
            System.out.print(nAtual + " -> ");

            nAtual = nextCollatz(nAtual);
        }
        System.out.println(nAtual);
        System.out.printf("Soma dos termos: %d", calculateCollatzSum(n));
    }
    
}