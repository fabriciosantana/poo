/*

Até 3 horas: taxa fixa de R$2.00.
Acima de 3 horas: cobrança de R$0.50 por hora extra.
Taxa máxima: R$10.00 para um período de 24 horas.

O usuário deve inserir as horas estacionadas para cada cliente.
O programa deve exibir a taxa de estacionamento para cada cliente.
Deve ser calculado e exibido o total arrecadado ao longo do dia.

*/

// calculateCharges: calcula as taxas de estacionamento.

import java.util.Scanner;

public class ParkingGarage{

    // ---- Constantes para as regras de cobrança ---- //
    private static final double taxa_minima = 2.00;      
    private static final double horas_base = 3.0;        
    private static final double taxa_adicional = 0.50;   
    private static final double taxa_maxima = 10.00;    

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int numeroCliente = 1;
        double horasEstacionadas;

        while (true){
            System.out.printf("Digite o número de horas estacionadas para o cliente %d (ou -1 para sair): ", numeroCliente);
            horasEstacionadas = entrada.nextDouble();

            if (horasEstacionadas == -1){
                break;
            }

            // ---- Chama o método e calcula taxa do cliente atual ---- //
            double taxaCliente = calculateCharges(horasEstacionadas);

            // ---- Acumula o valor no total arrecadado ---- //
            totalArrecadado += taxaCliente;

            // ---- Exibe a taxa para o cliente atual ---- //
            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f\n\n", numeroCliente, taxaCliente);

            numeroCliente++;
        }

        // ---- Exibe o total arrecadado no dia ---- //
        System.out.printf("Total arrecadado ontem: R$%.2f\n", totalArrecadado);
        
        entrada.close();
    }

    public static double calculateCharges(double hours){
        double taxa = taxa_minima;

        // ---- Verifica se o tempo excede as horas base ---- //
        if (hours > horas_base){
            // ---- Arredonda as horas para cima ---- //
            double horasTotaisArredondadas = Math.ceil(hours);
            taxa = taxa_minima + (horasTotaisArredondadas - horas_base) * taxa_adicional;
        }

        // ---- Garante que a taxa não ultrapasse o valor máximo ---- //
        if (taxa > taxa_maxima){
            taxa = taxa_maxima;
        }

        // ---- Retorna o valor final da taxa ---- //
        return taxa;
    }
}
