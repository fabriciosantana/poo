import java.util.Scanner;

public class PassosElefante {

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Digite a posiçao da casa do amigo: ");
       int x = sc.nextInt();

       if (x < 1 || x > 1000000) {
           System.out.println("Valor inválido ");
           return;
       }
       int passos = calcularPassosMinimos(x);

       String saida = formatarSaida(passos);

       System.out.println(saida);

    }
    public static int calcularPassosMinimos(int x) {
       int passos = x/5;
       if (x % 5 != 0 ) {
           passos++;
       }
       return passos;
    }
    public static String formatarSaida(int passos) {

       return "O número mínimo de passos necessários é: " + passos;
    }
}