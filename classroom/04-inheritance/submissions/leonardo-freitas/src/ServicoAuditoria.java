public class ServicoAuditoria {
    public void registrar(Auditavel auditavel) {
        System.out.printf("[%s] %s%n",
                auditavel.obterIdentificador(),
                auditavel.gerarDescricaoAuditoria());
    }
}
