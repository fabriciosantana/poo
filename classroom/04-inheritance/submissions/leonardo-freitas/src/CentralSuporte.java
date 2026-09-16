public class CentralSuporte {
    public void processar(SolicitacaoAtendimento solicitacao) {
        System.out.printf("%s | %s | Prioridade: %d%n",
                solicitacao.obterProtocolo(),
                solicitacao.obterDescricao(),
                solicitacao.calcularPrioridade());
    }
}
