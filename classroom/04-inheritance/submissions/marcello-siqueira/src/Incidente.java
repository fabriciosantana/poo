public class Incidente extends SolicitacaoAtendimento {

    private int impacto;
    private int urgencia;

    public Incidente(String protocolo, String descricao, int impacto, int urgencia) {
        super(protocolo, descricao);
        this.impacto = normalizarNivel(impacto);
        this.urgencia = normalizarNivel(urgencia);
    }

    @Override
    public int calcularPrioridade() {
        return impacto * urgencia;
    }

    private int normalizarNivel(int nivel) {
        return nivel < 1 ? 1 : (nivel > 5 ? 5 : nivel);
    }
}
