public class PlanoProfissional extends PlanoAssinatura {
    private int limiteUsuarios;

    public PlanoProfissional(String nome, double mensalidade, int limiteUsuarios){
        super(nome, mensalidade);
        if(limiteUsuarios <= 0){
            this.limiteUsuarios = 1;
        } else{
            this.limiteUsuarios = limiteUsuarios;
        }
    }

    public int obterLimiteUsuarios(){
        return this.limiteUsuarios;
    }
}