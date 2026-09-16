public class Produto {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public Produto(String nome, double precoUnitario, int quantidade) {
        if (nome == null || nome.isBlank()) {
            this.nome = "Produto sem nome";
        } else {
            this.nome = nome;
        }

        if (precoUnitario >= 0.0) {
            this.precoUnitario = precoUnitario;
        } else {
            this.precoUnitario = 0.0;
        }

        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 0;
        }
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public boolean retirarEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    public String obterNome() {
        return this.nome;
    }

    public double obterPrecoUnitario() {
        return this.precoUnitario;
    }

    public int obterQuantidade() {
        return this.quantidade;
    }

    public double calcularValorEstoque() {
        return this.quantidade * this.precoUnitario;
    }
}