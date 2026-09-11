public class CobrancasApp {

    public static void main(String[] argumentos) {
        ProcessadorCobrancas processador = new ProcessadorCobrancas();

        // as tres referencias sao do tipo geral; quem escolhe o calculo e o objeto, nao o processador
        Cobranca produto = new CobrancaProduto("Notebook", 5000.00);
        Cobranca servico = new CobrancaServico("Instalação", 300.00);
        Cobranca generica = new Cobranca("Reembolso", 120.00);

        processador.processar(produto);
        processador.processar(servico);
        processador.processar(generica);

        processador.processar(new CobrancaProduto("Valor inválido", -80.00));
        processador.processar(new CobrancaServico("Valor de fronteira", 0.0));
    }
}
