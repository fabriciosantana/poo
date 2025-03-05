import java.util.Scanner;

public class PassosElefante {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        scanner.close();
        
        if (x < 1 || x > 1_000_000) {
            System.out.println("Valor inválido! A posição deve estar entre 1 e 1.000.000.");
            return;
        }
        
        int passosMinimos = calcularPassosMinimos(x);
        System.out.println(formatarSaida(passosMinimos));
    }
    
    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5; // Divide por 5 e arredonda para cima
    }
    
    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}
