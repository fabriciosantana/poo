public class CobrancasApp {
    public static void main(String[] argumentos) {
        Cobranca produto = new CobrancaProduto("Notebook", 3000.0);
        Cobranca servico = new CobrancaServico("Instalação", 500.0);

        ProcessadorCobrancas processador = new ProcessadorCobrancas();
        processador.processar(produto);
        processador.processar(servico);
    }
}
