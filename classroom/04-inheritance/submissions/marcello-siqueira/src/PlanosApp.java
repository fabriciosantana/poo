public class PlanosApp {

    public static void main(String[] argumentos) {
        PlanoAssinatura basico = new PlanoAssinatura("Plano Básico", 49.90);
        System.out.println(basico.obterDescricao());

        PlanoProfissional profissional = new PlanoProfissional("Plano Profissional", 199.90, 25);
        System.out.println(profissional.obterDescricao() + ", até " + profissional.obterLimiteUsuarios() + " usuários");

        PlanoAssinatura invalido = new PlanoAssinatura("  ", -10.0);
        System.out.println("Inválido: " + invalido.obterDescricao());

        PlanoProfissional fronteira = new PlanoProfissional("Plano Solo", 0.0, 0);
        System.out.println("Fronteira: " + fronteira.obterDescricao() + ", até " + fronteira.obterLimiteUsuarios() + " usuários");
    }
}
