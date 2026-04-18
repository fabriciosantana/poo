import java.util.Scanner;

class SavingsAccount {
    private double saldo;
    private static double jurosAnual;

    public SavingsAccount(double valorInicial) {
        saldo = valorInicial;
    }

    public void jurosMes() {
        double jurosMes = Math.pow(1 + jurosAnual, 1.0/12) - 1;
        saldo = saldo + (saldo * jurosMes);
    }

    public static void definirJuros(double taxa) {
        jurosAnual = taxa;
    }

    public double pegarSaldo() {
        return saldo;
    }
}

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Informe o saldo inicial: ");
        double inicio = entrada.nextDouble();
        
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa1 = entrada.nextDouble() / 100.0;
        
        SavingsAccount c1 = new SavingsAccount(inicio);
        SavingsAccount.definirJuros(taxa1);
        
        System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", taxa1*100);
        
        for(int m=1; m<=12; m++) {
            c1.jurosMes();
            System.out.printf("Mês %d: R$ %.2f%n", m, c1.pegarSaldo());
        }
        
        System.out.print("%nInforme a nova taxa de juros anual (%): ");
        double taxa2 = entrada.nextDouble() / 100.0;
        
        SavingsAccount.definirJuros(taxa2);
        System.out.println("Alterando taxa de juros anual para " + (int)(taxa2*100) + "%...");
        
        c1.jurosMes();
        System.out.printf("Mês 13: R$ %.2f%n", c1.pegarSaldo());
        
        entrada.close();
    }
}