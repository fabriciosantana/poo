import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if(x >= 1 && x <= 1000000){
            int ps = calcularPassosMinimos(x);
            System.out.println(formatarSaida(ps));
        } else {
            System.out.println("Digite números entre 1 e 1,000,000");
        }

    }
    
    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
        }
    
        public static String formatarSaida(int ps){
            return String.format("O número mínimo de passos necessários é: %d", ps);
        }

}
