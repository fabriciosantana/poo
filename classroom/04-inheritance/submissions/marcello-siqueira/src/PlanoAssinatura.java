public class PlanoAssinatura {

    private String nome;
    private double mensalidade;

    public PlanoAssinatura(String nome, double mensalidade) {
        this.nome = (nome == null || nome.isBlank()) ? "Plano sem nome" : nome;
        this.mensalidade = mensalidade < 0 ? 0 : mensalidade;
    }

    public String obterNome() { return nome; }

    public double obterMensalidade() { return mensalidade; }

    public String obterDescricao() {
        return String.format("%s, mensalidade R$ %.2f", nome, mensalidade);
    }
}
