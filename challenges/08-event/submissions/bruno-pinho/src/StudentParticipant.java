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
        return "Estudante do curso de " + this.course + " no " + this.currentSemester + "º semestre.";
    }

    @Override
    public String toString() {

        return "StudentParticipant{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", course='" + course + '\'' +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
