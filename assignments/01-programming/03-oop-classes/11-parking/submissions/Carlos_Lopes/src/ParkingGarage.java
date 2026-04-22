import java.util.Scanner;
public class ParkingGarage{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double hours = 0;
        double PreçoFinal = 0;
        int id = 0;

        while (true){
        id++;

        System.out.println("Digite o número de horas estacionadas para o cliente " + (id) + " (ou -1 para sair): ");
        hours  = scanner.nextDouble();
             if(hours <= 0 || hours > 24){
                System.out.println("Erro: o número de horas excede o Limite de 0 a 24 horas. Por favor, insira um valor válido.\n");
                id--;
                continue;
             } else if (hours == -1){
                break;
             }

        System.out.printf("Cliente " + (id) + ": Taxa de Estacionamento: $" + calculateCharges(hours));

        PreçoFinal += calculateCharges(hours);
        
        }

        System.out.println("Total arrecadado ontem: $" + PreçoFinal);

        System.out.print("Programa Finalizado!");
    }

    public static double calculateCharges(double hours){
        double valor = 0;

        //taxa mínima de R$2.00** para até **3 horas
        if( hours <= 3){
            valor = 2;
            
        } else if ( hours > 3 && hours <= 24){
            valor = 2 + (hours - 3) * 0.5;
        }
        return valor;
    }

}