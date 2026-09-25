public class Carteira {

    private String titular;
    private double saldo;

    public Carteira(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo < 0 ? 0 : saldo;
    }

    public String obterTitular() { return titular; }

    public double obterSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("o depósito exige valor positivo, recebido " + valor);
        }

        saldo = saldo + valor;
    }

    // as duas checagens acontecem antes de qualquer atribuicao, entao a operacao recusada
    // devolve o controle sem ter tocado no saldo
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("o saque exige valor positivo, recebido " + valor);
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException("saldo de " + saldo + " é menor que o saque de " + valor);
        }

        saldo = saldo - valor;
    }
}
