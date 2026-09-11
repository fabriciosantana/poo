public class AuditoriaApp {
    public static void main(String[] argumentos) {
        Auditavel contrato = new ContratoComercial("CTR-2026-001", "Empresa Alfa");
        Auditavel acesso = new AcessoSistema("LOGIN-7788", "leonardo");

        ServicoAuditoria auditoria = new ServicoAuditoria();
        auditoria.registrar(contrato);
        auditoria.registrar(acesso);
    }
}
