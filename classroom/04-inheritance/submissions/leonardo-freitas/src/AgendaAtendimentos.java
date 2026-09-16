public class AgendaAtendimentos {
    public String agendar(String nomeCliente) {
        return agendar(nomeCliente, 30, false);
    }

    public String agendar(String nomeCliente, int duracaoEmMinutos) {
        return agendar(nomeCliente, duracaoEmMinutos, false);
    }

    public String agendar(String nomeCliente, int duracaoEmMinutos, boolean prioritario) {
        String nome = (nomeCliente == null || nomeCliente.isBlank())
                ? "Cliente não identificado"
                : nomeCliente;
        int duracao = duracaoEmMinutos > 0 ? duracaoEmMinutos : 30;
        String prioridade = prioritario ? "PRIORITÁRIO" : "NORMAL";

        return String.format("Cliente: %s | Duração: %d min | Prioridade: %s",
                nome, duracao, prioridade);
    }
}
