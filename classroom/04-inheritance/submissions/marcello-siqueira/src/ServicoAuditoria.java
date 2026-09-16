public class ServicoAuditoria {

    public void registrar(Auditavel auditavel) {
        System.out.println(auditavel.obterIdentificador() + ": " + auditavel.gerarDescricaoAuditoria());
    }
}
