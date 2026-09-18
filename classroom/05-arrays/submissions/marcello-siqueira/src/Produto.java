public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = (nome == null || nome.isBlank()) ? "Produto sem nome" : nome;
        this.preco = preco < 0 ? 0 : preco;
    }

    public String obterNome() { return nome; }

    public double obterPreco() { return preco; }
}
