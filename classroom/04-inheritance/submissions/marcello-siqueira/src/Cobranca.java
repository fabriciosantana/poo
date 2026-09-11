public class Cobranca {

    private String descricao;
    private double valorBase;

    public Cobranca(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase < 0 ? 0 : valorBase;
    }

    public String obterDescricao() { return descricao; }

    public double obterValorBase() { return valorBase; }

    public double calcularTotal() {
        return valorBase;
    }
}
