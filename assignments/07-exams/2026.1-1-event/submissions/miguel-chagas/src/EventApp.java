import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("S001", "João Silva", "joao@email.com", "Engenharia", 3));
        participants.add(new StudentParticipant("S002", "Maria Santos", "maria@email.com", "Direito", 5));
        participants.add(new ProfessionalParticipant("P001", "Carlos Oliveira", "carlos@empresa.com", "Tech Solutions"));
        participants.add(new ProfessionalParticipant("P002", "Ana Souza", "ana@corp.com", "Global Systems"));

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println();
        }
    }
}
