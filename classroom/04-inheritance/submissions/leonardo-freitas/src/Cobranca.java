public class Cobranca {
    private String descricao;
    private double valorBase;

    public Cobranca(String descricao, double valorBase) {
        this.descricao = (descricao == null || descricao.isBlank())
                ? "Cobrança sem descrição"
                : descricao;
        this.valorBase = Math.max(0.0, valorBase);
    }

    public String obterDescricao() {
        return descricao;
    }

    public double obterValorBase() {
        return valorBase;
    }

    public double calcularTotal() {
        return valorBase;
    }
}
