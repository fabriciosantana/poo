import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite a posição da casa do amigo: ");
        int x = sc.nextInt();
        
        if (x < 1 || x > 1_000_000) {
            System.out.println("Erro! O valor de a posição da casa do amigo deve estar entre 1 e 1.000.000.");
            return;
        }

        int passos = calcularPassosMinimos(x);
        String saida = formatarSaida(passos);

        System.out.println(saida);

        sc.close();
    }

    public static int calcularPassosMinimos(int x) {
        int quociente = x / 5;
        int resto = x % 5;
        return (resto == 0) ? quociente : quociente + 1;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}
