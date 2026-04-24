import java.util.Scanner;
public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();
        if (x < 1 || x > 1000000) {
            System.out.println("Valor inválido. O número deve ser entre 1 e 1.000.000.");
            scanner.close();
            return;
        }
        int passos = calcularPassosMinimos(x);
        String resultado = formatarSaida(passos);
        System.out.println(resultado);
        scanner.close();
    }

    public static int calcularPassosMinimos(int x){
        return (x + 4) / 5;
    }
    public static String formatarSaida(int passos) {
        
        return "O número mínimo de passos necessários é: " + passos;
        
    }
    

}
