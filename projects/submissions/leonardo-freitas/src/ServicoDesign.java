public class ServicoDesign extends Servico {
    private final int quantidadePecas;
    private final boolean urgente;

    public ServicoDesign(String descricao, double valorBase, int quantidadePecas, boolean urgente) {
        super(descricao, valorBase);
        if (quantidadePecas <= 0) {
            throw new IllegalArgumentException("A quantidade de peças deve ser positiva.");
        }
        this.quantidadePecas = quantidadePecas;
        this.urgente = urgente;
    }

    @Override
    public double calcularValorFinal() {
        double valor = getValorBase() + quantidadePecas * 50.0;
        if (urgente) {
            valor *= 1.20;
        }
        return valor;
    }

    @Override
    public String getTipo() {
        return "Design";
    }

    public int getQuantidadePecas() { return quantidadePecas; }
    public boolean isUrgente() { return urgente; }
}
