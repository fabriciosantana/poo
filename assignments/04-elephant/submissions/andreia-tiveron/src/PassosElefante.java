import java.util.Scanner;

public class PassosElefante{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if(x<1 || x>1000000){
            System.out.println("O valor não está dentro do intervalo permitido."); 
        }else{
            int passos = calcularPassosMinimos(x);
            System.out.println(formatarSaida(passos));
        }

        scanner.close();

    }

    public static int calcularPassosMinimos(int x){
        if (x%5 == 0){
            return x/5;
        }else {
            return (x+4)/5;
        }
    }

    public static String formatarSaida(int passos){
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
