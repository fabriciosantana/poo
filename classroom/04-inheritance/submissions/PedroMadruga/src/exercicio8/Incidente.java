public class Incidente extends SolicitacaoSuporte {
    private int impacto;
    private int urgencia;

    public Incidente(String protocolo, String descricao, int impacto, int urgencia) {
        super(protocolo, descricao);
        this.impacto = normalizarEscala(impacto);
        this.urgencia = normalizarEscala(urgencia);
    }

    private int normalizarEscala(int valor) {
        if (valor < 1) return 1;
        if (valor > 5) return 5;
        return valor;
    }

    @Override
    public int calcularPrioridade() {
        return impacto * urgencia;
    }
}