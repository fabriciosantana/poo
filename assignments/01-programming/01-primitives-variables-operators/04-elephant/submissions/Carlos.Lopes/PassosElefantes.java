import java.util.Scanner;

public class PassosElefantes {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a posição da casa do amigo: ");

        if((!scanner.hasNextInt())) {
            System.out.println("Por Favor digite um número valido");
        }

        int x = scanner.nextInt();
        int upperbound = 1000000;
        int lowerbound = 1;

        if( x < lowerbound || x > upperbound){
            System.out.println("A distância está entre 1 a 1.000.000");
        } else {
            int passos = calcularPassosMinimos(x);
            formatarSaida(x, passos);
        }

    }
    public static int calcularPassosMinimos(int x){
    /*
    passos possíveis 1|2|3|4|5 do elefante
    saber o mínimo necessário até completar x distância
    maior passo é: 5 
    */
   if( x % 5 == 0){
    return x / 5;
   } else{
    return (x / 5) + 1;
   }

    }
    public static int formatarSaida(int x, int passos){
        System.out.println("O número mínimo de passos necessários é: " + passos);
        return passos;

    }
    
}
