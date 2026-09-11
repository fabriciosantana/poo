public class AuditoriaApp {

    public static void main(String[] argumentos) {
        ServicoAuditoria servico = new ServicoAuditoria();

        // contrato e acesso nao compartilham hierarquia, so o contrato Auditavel
        Auditavel contrato = new ContratoComercial("CT-2026-77", "Construtora Planalto");
        Auditavel acesso = new AcessoSistema("AC-4512", "marcello.siqueira");

        servico.registrar(contrato);
        servico.registrar(acesso);

        servico.registrar(new ContratoComercial("", null));
        servico.registrar(new AcessoSistema("  ", ""));
    }
}
