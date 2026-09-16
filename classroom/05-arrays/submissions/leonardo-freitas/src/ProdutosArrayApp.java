public class ProdutosArrayApp {
    private static void exibirECalcular(Produto[] produtos) {
        double total = 0.0;
        for (int i = 0; i < produtos.length; i++) {
            // A posição i pertence ao array; o objeto Produto é a referência armazenada nessa posição.
            Produto produto = produtos[i];
            if (produto == null) {
                System.out.println("Posição " + i + ": SEM PRODUTO");
                continue;
            }
            System.out.println(produto.obterNome());
            total += produto.obterPreco();
        }
        System.out.printf("Total: R$ %.2f%n", total);
    }

    public static void main(String[] args) {
        Produto[] completos = {
                new Produto("Teclado", 120.0),
                new Produto("Mouse", 80.0),
                new Produto("Monitor", 900.0)
        };
        exibirECalcular(completos);

        System.out.println("--- Com posição null ---");
        Produto[] comNull = {
                new Produto("Teclado", 120.0),
                null,
                new Produto("Monitor", 900.0)
        };
        exibirECalcular(comNull);
    }
}
