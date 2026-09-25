public class Carteira {
    private final String titular;
    private double saldo;

    public Carteira(String titular, double saldoInicial) {
        this.titular = titular == null ? "" : titular.trim();
        this.saldo = Double.isFinite(saldoInicial) && saldoInicial > 0 ? saldoInicial : 0.0;
    }

    public void depositar(double valor) {
        validarValorPositivo(valor);
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        validarValorPositivo(valor);
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque.");
        }
        saldo -= valor;
    }

    private void validarValorPositivo(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
