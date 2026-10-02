import java.util.Scanner;

public class SequenciaFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade = scanner.nextInt();

        if (quantidade <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            long termoAtual = 0;
            long proximoTermo = 1;

            for (int posicao = 1; posicao <= quantidade; posicao++) {
                if (posicao > 1) {
                    System.out.print(" ");
                }
                System.out.print(termoAtual);

                long soma = termoAtual + proximoTermo;
                termoAtual = proximoTermo;
                proximoTermo = soma;
            }
            System.out.println();
        }

        scanner.close();
    }
}
