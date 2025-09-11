import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int semente = entrada.nextInt();
        entrada.close();

        //---- Validar a entrada do usuário ----//
        if (semente < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return; 
        }

        //---- Gerar a sequência ----//
        StringBuilder sequencia = new StringBuilder();
        sequencia.append(semente); //---- Adiciona o primeiro número ----//
        
        int numeroAtual = semente;
        while (numeroAtual != 1) {
            numeroAtual = CollatzSequence.nextCollatz(numeroAtual);
            sequencia.append(" → ").append(numeroAtual);
        }

        //---- Calcular a soma ----//
        long soma = CollatzSequence.calculateCollatzSum(semente);
        
        //---- Exibir os resultados ----//
        System.out.println("Sequência de Collatz: " + sequencia.toString());
        System.out.println("Soma dos termos: " + soma);
    }
}


public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            //---- Se n for par ----//
            return n / 2;
        } else {
            //---- Se n for ímpar ----//
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        //---- A soma do tipo 'long' para evitar estouro ----//
        long somaTotal = n;
        int numeroAtual = n;

        //---- Loop while para calcular a soma até chegar em 1 ----//
        while (numeroAtual != 1) {
            numeroAtual = nextCollatz(numeroAtual);
            somaTotal += numeroAtual;
        }
        return somaTotal;
    }
}
