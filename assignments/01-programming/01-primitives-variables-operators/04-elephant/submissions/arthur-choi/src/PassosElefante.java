import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int posicaoAmigo = ler.nextInt();

        if (posicaoAmigo < 0 || posicaoAmigo > 1000000) {
            System.out.println("O número deve estar entre 0 e 1000000.");
        } else {
            int passos = calcularPassosMinimos(posicaoAmigo);
            System.out.println(formatarSaida(passos));
        }
        
    }

    /* Método para calcular o número mínimo de passos necessários
    * O elefante pode dar passos de 5 unidades, então dividimos a posição do amigo por 5
    * Se houver um resto, significa que o elefante precisará de um passo extra
    */ 
    public static int calcularPassosMinimos(int x) {
        int passos = x / 5;
        if (x % 5 != 0) {
            passos++;
        }
        return passos;
    }

    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
