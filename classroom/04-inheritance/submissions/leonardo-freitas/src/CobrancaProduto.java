public class CobrancaProduto extends Cobranca {
    public CobrancaProduto(String descricao, double valorBase) {
        super(descricao, valorBase);
    }

    @Override
    public double calcularTotal() {
        return obterValorBase() * 1.10;
    }
}
