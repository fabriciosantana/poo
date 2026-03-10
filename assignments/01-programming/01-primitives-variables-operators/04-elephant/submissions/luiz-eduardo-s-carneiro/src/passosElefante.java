import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite a posição da casa do amigo: ");
        int position = scanner.nextInt();

        int passos = calcularPassosMinimos(position);

        System.out.println(formatarSaida(passos));

    }

    public static int calcularPassosMinimos(int x){
        
        for(int passos = 1; passos <= 5; passos++){
            if(x / passos <= 5){
                return passos;
            }
        }

        return 5;
    }

    public static String formatarSaida(int passos){

        return "O número mínimo de passos necessários é: " + passos;
    }
}

