public class ProdutosArray {

    // A posicao do array guarda uma referencia, nao o objeto em si.
    // Uma posicao pode existir e valer null: o array tem tamanho 3 mesmo
    // quando so dois produtos foram criados.

    public static void main(String[] argumentos) {
        Produto[] produtos = new Produto[3];
        produtos[0] = new Produto("Caderno", 24.90);
        produtos[1] = new Produto("Caneta", 3.50);
        produtos[2] = new Produto("Mochila", 189.00);

        listar(produtos);

        System.out.println();
        Produto[] comLacuna = new Produto[3];
        comLacuna[0] = new Produto("Borracha", 2.00);
        comLacuna[2] = new Produto("Régua", 6.75);

        listar(comLacuna);
    }

    static void listar(Produto[] produtos) {
        double soma = 0;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                System.out.println("posição " + i + ": vazia");
            } else {
                System.out.printf("posição %d: %s, R$ %.2f%n",
                        i, produtos[i].obterNome(), produtos[i].obterPreco());
                soma += produtos[i].obterPreco();
            }
        }

        System.out.printf("Soma dos preços: R$ %.2f%n", soma);
    }
}
