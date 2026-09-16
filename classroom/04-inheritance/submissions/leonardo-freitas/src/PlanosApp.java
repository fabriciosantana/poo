public class PlanosApp {
    public static void main(String[] argumentos) {
        PlanoAssinatura basico = new PlanoAssinatura("Plano Básico", 49.90);
        PlanoProfissional profissional = new PlanoProfissional("Plano Profissional", 149.90, 10);

        System.out.println(basico.obterDescricao());
        System.out.println(profissional.obterDescricao()
                + " - limite de " + profissional.obterLimiteUsuarios() + " usuários");
    }
}
