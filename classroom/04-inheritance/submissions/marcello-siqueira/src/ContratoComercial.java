public class ContratoComercial implements Auditavel {

    private String numero;
    private String parteContratada;

    public ContratoComercial(String numero, String parteContratada) {
        this.numero = normalizar(numero, "Contrato sem número");
        this.parteContratada = normalizar(parteContratada, "Parte não informada");
    }

    @Override
    public String obterIdentificador() { return numero; }

    @Override
    public String gerarDescricaoAuditoria() {
        return "Contrato firmado com " + parteContratada;
    }

    private String normalizar(String valor, String padrao) {
        return (valor == null || valor.isBlank()) ? padrao : valor;
    }
}
