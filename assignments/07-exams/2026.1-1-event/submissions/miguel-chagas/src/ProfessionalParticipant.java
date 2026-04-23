public class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização " + organization + ".";
    }

    @Override
    public String toString() {
        return "Profissional: " + getFullName() + " (ID: " + getId() + ", Email: " + getEmail() + ")";
    }
}
