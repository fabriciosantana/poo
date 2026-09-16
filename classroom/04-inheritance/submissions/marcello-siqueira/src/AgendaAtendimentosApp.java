public class AgendaAtendimentosApp {

    public static void main(String[] argumentos) {
        AgendaAtendimentos agenda = new AgendaAtendimentos();

        System.out.println(agenda.agendar("Marcello Siqueira"));
        System.out.println(agenda.agendar("Amanda Ferreira", 45));
        System.out.println(agenda.agendar("Pedro Madruga", 60, true));

        System.out.println("Inválido: " + agenda.agendar("", -15));
        System.out.println("Fronteira: " + agenda.agendar("Ana Lima", 1));
    }
}
