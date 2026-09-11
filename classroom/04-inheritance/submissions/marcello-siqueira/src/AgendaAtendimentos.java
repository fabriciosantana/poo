public class AgendaAtendimentos {

    public String agendar(String nomeCliente) {
        return agendar(nomeCliente, 30);
    }

    public String agendar(String nomeCliente, int duracaoEmMinutos) {
        return agendar(nomeCliente, duracaoEmMinutos, false);
    }

    public String agendar(String nomeCliente, int duracaoEmMinutos, boolean prioritario) {
        String nome = (nomeCliente == null || nomeCliente.isBlank()) ? "Cliente não identificado" : nomeCliente;
        int duracao = duracaoEmMinutos <= 0 ? 30 : duracaoEmMinutos;
        return String.format("%s, %d min, %s", nome, duracao, prioritario ? "prioritário" : "normal");
    }
}
