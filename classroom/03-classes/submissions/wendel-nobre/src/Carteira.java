public class Carteira {
    private String titular;
    private double saldo;

    public Carteira(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            this.titular = "Sem nome";
        } else {
            this.titular = titular;
        }

        if (saldoInicial < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }

    public boolean gastar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Carteira destino, double valor) {
        if (destino != null && destino != this && valor > 0 && this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            destino.saldo = destino.saldo + valor;
            return true;
        }
        return false;
    }
}