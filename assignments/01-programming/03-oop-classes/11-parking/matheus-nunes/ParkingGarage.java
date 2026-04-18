import java.util.Scanner;
public class ParkingGarage{
    public static double calculateCharges(double hours){
if(hours <= 3){
    return 2.00;
}else if( hours > 3 && hours <=19){
double horasArredondadas = Math.ceil(hours);
return (horasArredondadas - 3) * 0.50 + 2.00;
}else{
    return 10.00;
}
}
public static void main(String[] args){
    double hours = 0;
    double totalarrecadado = 0;
    int contador = 0;
    Scanner teclado = new Scanner(System.in);
    do{
     System.out.println(" Digite o número de horas estacionadas para o cliente (ou -1 para sair):");
     hours = teclado.nextDouble();
     if(hours == -1){
        break;
     }else{
        double charge = calculateCharges(hours);
        totalarrecadado += charge;
        contador++;
        System.out.printf("Cliente %d: Taxa de estacionamento: R$ %.2f%n", contador, charge);
     }
    

    }while(hours != -1);

   System.out.printf("Total arrecadado ontem: R$ %.2f%n", totalarrecadado);

    }
}