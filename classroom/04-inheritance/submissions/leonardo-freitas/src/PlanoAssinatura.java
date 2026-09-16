public class PlanoAssinatura {
    private String nome;
    private double mensalidade;

    public PlanoAssinatura(String nome, double mensalidade) {
        this.nome = (nome == null || nome.isBlank()) ? "Plano sem nome" : nome;
        this.mensalidade = (!Double.isFinite(mensalidade) || mensalidade < 0.0) ? 0.0 : mensalidade;
    }

    public String obterNome() {
        return nome;
    }

    public double obterMensalidade() {
        return mensalidade;
    }

    public String obterDescricao() {
        return String.format("%s - R$ %.2f/mês", nome, mensalidade);
    }
}
