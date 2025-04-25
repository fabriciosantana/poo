import java.util.Scanner;

public class PassosElefante {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a posição da casa do amigo: ");
        int n = scanner.nextInt();
        scanner.close();

        if(n < 1 || n > 1000000){
            System.out.println("A posição deve estar entre 1 e 1.000.000");
            return;
        }
        
        int passos = calcularPassosMinimos(n);
        String saida = formatarSaida(passos);

        System.out.println(saida);
    }
    
    public static int calcularPassosMinimos(int n){
        return (n + 4) / 5;
    }

    public static String formatarSaida(int passos){
        return "O número mínimo de passos necessários é: " + passos;
    }
}
