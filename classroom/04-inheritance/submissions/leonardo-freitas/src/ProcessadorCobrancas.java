public class ProcessadorCobrancas {
    public void processar(Cobranca cobranca) {
        System.out.printf("%s | Total: R$ %.2f%n",
                cobranca.obterDescricao(),
                cobranca.calcularTotal());
    }
}
