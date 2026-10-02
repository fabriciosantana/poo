public class AgendaAtendimentosApp {
    public static void main(String[] args) {
        AgendaAtendimentos agenda = new AgendaAtendimentos();

        System.out.println(agenda.agendar("Carlos Silva"));
        System.out.println(agenda.agendar("Mariana Rios", 45));
        System.out.println(agenda.agendar("João Lucas", 60, true));
        System.out.println(agenda.agendar("", -10, false));
    }
}