public class SolicitacaoServico extends SolicitacaoAtendimento {
    private int usuariosAfetados;

    public SolicitacaoServico(String protocolo, String descricao, int usuariosAfetados) {
        super(protocolo, descricao);
        this.usuariosAfetados = Math.max(0, usuariosAfetados);
    }

    @Override
    public int calcularPrioridade() {
        return Math.min(25, 1 + usuariosAfetados / 10);
    }
}
