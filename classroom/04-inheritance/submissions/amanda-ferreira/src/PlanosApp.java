public class PlanosApp {
    public static void main(String [] args){
        PlanoAssinatura PlanoBasico = new PlanoAssinatura("Plano Básico", 59.90);
        System.out.println(PlanoBasico.obterDescricao());
        System.out.println();

        PlanoProfissional PlanoPro = new PlanoProfissional("Plano Profissional", 119.90, 20);
        System.out.println(PlanoPro.obterDescricao());
        System.out.println("Limite de usuários: " + PlanoPro.obterLimiteUsuarios());
        System.out.println();

        PlanoAssinatura PlanoInvalido = new PlanoAssinatura(null, 0);
        System.out.println(PlanoInvalido.obterDescricao());
        System.out.println();

        PlanoProfissional PlanoProInvalido = new PlanoProfissional(null, 0, 0);
        System.out.println(PlanoProInvalido.obterDescricao());
        System.out.println("Limite de usuários: " + PlanoProInvalido.obterLimiteUsuarios());
    }
}