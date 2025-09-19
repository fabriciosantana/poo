import java.util.Scanner;

public class ParkingGarage {
    public double calculateCharges(double hours) {
        double tax, hoursExtra;

        if(hours <= 3.00) {
            tax = 2.00;

            return tax;
        }

        if(hours <= 24) {
            hoursExtra -= hours;

            tax = (hoursExtra * 0.50) + 2.00;

            return tax;
        }

        if(hours > 24) {
            tax = 10.00;
            
            return tax;
        }
    }

    public static void main(String[] args) {
        try {
            double taxMax;
            int count = 1;

            Scanner input = new Scanner(System.in);

            while (hours != -1) {
                double hours, tax;

                System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
                hours = input.nextDouble();

                tax = calculateCharges(hours);

                System.out.printf("Cliente %d: Taxa de estacionamento: $%d", count, tax);

                taxMax += tax;
                count++;
            }

            System.out.printf("Total arrecadado ontem: $%d", taxMax);
        }
    }
}