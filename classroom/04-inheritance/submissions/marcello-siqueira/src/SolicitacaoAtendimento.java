public abstract class SolicitacaoAtendimento {

    private String protocolo;
    private String descricao;

    public SolicitacaoAtendimento(String protocolo, String descricao) {
        this.protocolo = protocolo;
        this.descricao = descricao;
    }

    public String obterProtocolo() { return protocolo; }

    public String obterDescricao() { return descricao; }

    public abstract int calcularPrioridade();
}
