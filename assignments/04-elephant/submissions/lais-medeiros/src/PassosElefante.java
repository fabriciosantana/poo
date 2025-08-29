
import java.util.Scanner;

public class PassosElefante {
    
    public static int calcularPassosMinimos(int x) {
        
        int passosDeCinco = x / 5;
        int resto = x % 5;
        int passosExtras = (resto > 0) ? 1 : 0;
        
        return passosDeCinco + passosExtras;
    }
    
    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        
        int passosMinimos = calcularPassosMinimos(x);
        String saida = formatarSaida(passosMinimos);
        
        System.out.println(saida);
        
        scanner.close();
    }
}