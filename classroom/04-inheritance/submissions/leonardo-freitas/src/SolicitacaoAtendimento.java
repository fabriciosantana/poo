public abstract class SolicitacaoAtendimento {
    private String protocolo;
    private String descricao;

    public SolicitacaoAtendimento(String protocolo, String descricao) {
        this.protocolo = (protocolo == null || protocolo.isBlank())
                ? "Protocolo não informado"
                : protocolo;
        this.descricao = (descricao == null || descricao.isBlank())
                ? "Descrição não informada"
                : descricao;
    }

    public String obterProtocolo() {
        return protocolo;
    }

    public String obterDescricao() {
        return descricao;
    }

    public abstract int calcularPrioridade();
}
