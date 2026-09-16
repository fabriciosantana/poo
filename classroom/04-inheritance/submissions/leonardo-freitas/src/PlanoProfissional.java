public class PlanoProfissional extends PlanoAssinatura {
    private int limiteUsuarios;

    public PlanoProfissional(String nome, double mensalidade, int limiteUsuarios) {
        super(nome, mensalidade);
        this.limiteUsuarios = limiteUsuarios > 0 ? limiteUsuarios : 1;
    }

    public int obterLimiteUsuarios() {
        return limiteUsuarios;
    }
}
