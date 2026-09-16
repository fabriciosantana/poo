public class SolicitacaoServico extends SolicitacaoAtendimento {

    private int usuariosAfetados;

    public SolicitacaoServico(String protocolo, String descricao, int usuariosAfetados) {
        super(protocolo, descricao);
        this.usuariosAfetados = usuariosAfetados < 0 ? 0 : usuariosAfetados;
    }

    @Override
    public int calcularPrioridade() {
        int prioridade = 1 + usuariosAfetados / 10;
        return prioridade > 25 ? 25 : prioridade;
    }
}
