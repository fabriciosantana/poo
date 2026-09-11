public class AcessoSistema implements Auditavel {

    private String codigo;
    private String usuario;

    public AcessoSistema(String codigo, String usuario) {
        this.codigo = normalizar(codigo, "Acesso sem código");
        this.usuario = normalizar(usuario, "Usuário não informado");
    }

    @Override
    public String obterIdentificador() { return codigo; }

    @Override
    public String gerarDescricaoAuditoria() {
        return "Acesso ao sistema pelo usuário " + usuario;
    }

    private String normalizar(String valor, String padrao) {
        return (valor == null || valor.isBlank()) ? padrao : valor;
    }
}
