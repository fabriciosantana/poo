import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProfessionalParticipantTest {

    @Test
    void describeRoleShouldMentionOrganization() {
        ProfessionalParticipant participant = new ProfessionalParticipant(
                "pro-101",
                "Daniel Rocha",
                "daniel@example.com",
                "IDP Tech"
        );

        String description = participant.describeRole();

        assertTrue(description.contains("IDP Tech"));
    }

    @Test
    void toStringShouldContainKeyInformation() {
        ProfessionalParticipant participant = new ProfessionalParticipant(
                "pro-102",
                "Eduarda Souza",
                "eduarda@example.com",
                "Consultoria Inova"
        );

        String text = participant.toString();

        assertTrue(text.contains("pro-102"));
        assertTrue(text.contains("Eduarda Souza"));
        assertTrue(text.contains("Consultoria Inova"));
        assertTrue(text.contains("eduarda@example.com"));
    }

    @Test
    void gettersShouldReturnConstructorValues() {
        ProfessionalParticipant participant = new ProfessionalParticipant(
                "pro-103",
                "Fernanda Lima",
                "fernanda@example.com",
                "Tech Corp"
        );

        assertEquals("pro-103", participant.getId());
        assertEquals("Fernanda Lima", participant.getFullName());
        assertEquals("fernanda@example.com", participant.getEmail());
    }
}
