import java.util.Scanner;

public class MaquinaVendas {
    private String produto;
    private double preco;
    private int estoque;
    private double credito;

    public MaquinaVendas(String produto, double preco, int estoque) {
        if (produto == null || produto.trim().isEmpty()) {
            this.produto = "Produto não informado";
        } else {
            this.produto = produto;
        }

        if (preco <= 0) {
            this.preco = 1.0;
        } else {
            this.preco = preco;
        }

        if (estoque < 0) {
            this.estoque = 0;
        } else {
            this.estoque = estoque;
        }

        this.credito = 0.0;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getCredito() {
        return credito;
    }

    public void inserirDinheiro(double valor) {
        if (valor > 0) {
            this.credito = this.credito + valor;
        }
    }

    public boolean comprar() {
        if (this.estoque > 0 && this.credito >= this.preco) {
            this.estoque = this.estoque - 1;
            this.credito = this.credito - this.preco;
            return true;
        }
        return false;
    }

    public double cancelar() {
        double valorDevolvido = this.credito;
        this.credito = 0.0;
        return valorDevolvido;
    }
}