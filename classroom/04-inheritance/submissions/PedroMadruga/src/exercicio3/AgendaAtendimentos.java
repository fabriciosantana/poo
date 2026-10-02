public class AgendaAtendimentos {

    public String agendar(String nomeCliente) {
        return agendar(nomeCliente, 30, false);
    }

    public String agendar(String nomeCliente, int duracaoMinutos) {
        return agendar(nomeCliente, duracaoMinutos, false);
    }

    public String agendar(String nomeCliente, int duracaoMinutos, boolean prioridade) {
        String clienteValido = (nomeCliente == null || nomeCliente.trim().isEmpty())
                ? "Cliente não identificado"
                : nomeCliente.trim();
        int duracaoValida = duracaoMinutos <= 0 ? 30 : duracaoMinutos;

        return String.format("Atendimento [Cliente: %s, Duração: %d min, Prioridade: %s]",
                clienteValido, duracaoValida, prioridade ? "Sim" : "Não");
    }
}