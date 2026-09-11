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
        if (nivel < 1) {
            return 1;
        }
        if (nivel > 5) {
            return 5;
        }
        return nivel;
    }
}
