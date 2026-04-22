import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.println("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        int passos = calcularPassosMinimos(x);
        String result = formatarSaida(passos);
        System.out.println(result);
    }
    public static int calcularPassosMinimos(int x){
        /*  if (x % 5 == 0) {
            return x / 5;
        } else {
            return (x / 5) + 1;
        }
    } */
        if (x % 5 == 0) {
            return x / 5;
        } else {
            return (x/5) + 1;
        }

    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos; 
    }
}
