public class AgendaAtendimentosApp {
    public static void main(String[] argumentos) {
        AgendaAtendimentos agenda = new AgendaAtendimentos();

        System.out.println(agenda.agendar("Ana"));
        System.out.println(agenda.agendar("Bruno", 45));
        System.out.println(agenda.agendar("Carla", 20, true));
    }
}
