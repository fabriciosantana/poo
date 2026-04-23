public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {
        return "Estudante do curso de " + course + ", no " + currentSemester + "º semestre.";
    }

    @Override
    public String toString() {
        return "Estudante: " + getFullName() + " (ID: " + getId() + ", Email: " + getEmail() + ")";
    }
}
