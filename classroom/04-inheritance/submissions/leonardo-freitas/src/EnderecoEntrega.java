public class EnderecoEntrega {
    private String logradouro;
    private String cidade;
    private String cep;

    EnderecoEntrega(String logradouro, String cidade, String cep) {
        this.logradouro = normalizar(logradouro, "Logradouro não informado");
        this.cidade = normalizar(cidade, "Cidade não informada");
        this.cep = normalizar(cep, "CEP não informado");
    }

    public String formatar() {
        return logradouro + " - " + cidade + " - " + cep;
    }

    private String normalizar(String valor, String padrao) {
        return (valor == null || valor.isBlank()) ? padrao : valor;
    }
}
