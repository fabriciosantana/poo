class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class Exercicio08 {
    public static void main(String[] args) {
        Produto[] estoque = new Produto[3];
        estoque[0] = new Produto("Caderno", 15.50);
        estoque[1] = new Produto("Caneta", 3.00);
        estoque[2] = new Produto("Mochila", 120.00);

        System.out.println("--- Execução 1: todos preenchidos ---");
        exibirEComporSoma(estoque);

        // Execução 2: deixando uma posição sem objeto (null)
        estoque[1] = null;

        System.out.println("\n--- Execução 2: com elemento null ---");
        exibirEComporSoma(estoque);

        /*
         * Explicação:
         * A posição do array 'estoque[i]' é apenas uma célula de memória que guarda uma
         * REFERÊNCIA (um ponteiro) para uma instância da classe Produto.
         * Quando um índice está vazio ou não atribuído, ele guarda o valor especial 'null'.
         * O objeto em si reside no Heap da memória Java; sem checar se estoque[i] != null,
         * chamar estoque[i].getPreco() resultaria em NullPointerException.
         */
    }

    public static void exibirEComporSoma(Produto[] produtos) {
        double total = 0.0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) {
                System.out.printf("Item: %-10s | Preço: R$ %.2f%n",
                        produtos[i].getNome(), produtos[i].getPreco());
                total += produtos[i].getPreco();
            } else {
                System.out.println("Posição " + i + ": [VAZIO / SEM PRODUTO]");
            }
        }
        System.out.printf("Total: R$ %.2f%n", total);
    }
}