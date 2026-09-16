public class ProcessadorCobrancas {

    public void processar(Cobranca cobranca) {
        System.out.printf("%s: base R$ %.2f, total R$ %.2f%n",
                cobranca.obterDescricao(), cobranca.obterValorBase(), cobranca.calcularTotal());
    }
}
