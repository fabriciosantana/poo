import java.util.Locale;

public class ProdutoApp {
    public static void main(String[] args) {
        Produto caderno = new Produto("Caderno Universitário", 18.50, 10);
        exibir("Estado Inicial", caderno);

        caderno.adicionarEstoque(5);
        exibir("Após Entrada (5 unidades)", caderno);

        boolean sucessoRetirada1 = caderno.retirarEstoque(8);
        System.out.println("Retirada de 8 unidades realizada? " + (sucessoRetirada1 ? "Sim" : "Não"));
        exibir("Após Retirada Válida", caderno);

        boolean sucessoRetirada2 = caderno.retirarEstoque(20);
        System.out.println("Retirada de 20 unidades realizada? " + (sucessoRetirada2 ? "Sim" : "Não"));
        exibir("Após Tentativa de Retirada Insuficiente", caderno);
    }

    private static void exibir(String operacao, Produto produto) {
        System.out.println("--- " + operacao + " ---");
        System.out.println("Produto: " + produto.obterNome());
        System.out.printf(Locale.US, "Preço Unitário: R$ %.2f%n", produto.obterPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto.obterQuantidade());
        System.out.printf(Locale.US, "Valor Total em Estoque: R$ %.2f%n", produto.calcularValorEstoque());
        System.out.println();
    }
}