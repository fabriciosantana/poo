import java.util.Locale;
import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);
        double faturamentoTotal = 0.0;
        int contadorClientes = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = entrada.nextDouble();

            if (hours == -1) {
                break;
            }

            double taxa = calculateCharges(hours);
            faturamentoTotal += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", contadorClientes, taxa);
            contadorClientes++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", faturamentoTotal);
        entrada.close();
    }

    public static double calculateCharges(double hours) {
        final double TAXA_MINIMA = 2.00;
        final double TAXA_MAXIMA = 10.00;
        final double TAXA_POR_HORA_EXTRA = 0.50;
        final double HORAS_BASE = 3.0;

        double taxaCalculada = TAXA_MINIMA;

        if (hours > HORAS_BASE) {
            taxaCalculada += Math.ceil(hours - HORAS_BASE) * TAXA_POR_HORA_EXTRA;
        }

        return Math.min(taxaCalculada, TAXA_MAXIMA);
    }
}