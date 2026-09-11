public class CentralSuporte {

    public void processar(SolicitacaoAtendimento solicitacao) {
        System.out.printf("%s: %s, prioridade %d%n",
                solicitacao.obterProtocolo(), solicitacao.obterDescricao(), solicitacao.calcularPrioridade());
    }
}
