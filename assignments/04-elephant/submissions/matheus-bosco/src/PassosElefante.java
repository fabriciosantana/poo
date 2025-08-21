import java.util.Scanner;

public class PassosElefante {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int n = scanner.nextInt();
    

        if (n < 1 || n > 1_000_000) {
            System.out.println("Valor inválido. Deve estar entre 1 e 1.000.000.");
            scanner.close();
            return;
        }

        int passos = calcularPassosMinimos(n);   //FUNÇÃO PARA CALCULAR QTD DE PASSOS
        String saida = formatarSaida(passos);    //FORMATAÇÃO DA SAIDA

        System.out.println(saida);

        scanner.close();

    }


    public static int calcularPassosMinimos(int n){  //5 É O TAMANHO MAXIMO DE PASSOS E 1 É O MINIMO, POR ISSO FAZEMOS N + 4 (1+4=5) E DIVIDIMOS POR 5
        return (n + 4) / 5;                          //O RETURN É IGUAL A passos         
    }

    public static String formatarSaida (int passos){
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }

}
