import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentParticipantTest {

    @Test
    void describeRoleShouldMentionCourseAndSemester() {
        StudentParticipant participant = new StudentParticipant(
                "stu-001",
                "Ana Martins",
                "ana@example.com",
                "Ciência da Computação",
                3
        );

        String description = participant.describeRole();

        assertTrue(description.contains("Ciência da Computação"));
        assertTrue(description.contains("semestre 3"));
    }

    @Test
    void toStringShouldContainKeyInformation() {
        StudentParticipant participant = new StudentParticipant(
                "stu-002",
                "Bruno Lima",
                "bruno@example.com",
                "Engenharia de Software",
                5
        );

        String text = participant.toString();

        assertTrue(text.contains("stu-002"));
        assertTrue(text.contains("Bruno Lima"));
        assertTrue(text.contains("Engenharia de Software"));
        assertTrue(text.contains("semestre 5"));
        assertTrue(text.contains("bruno@example.com"));
    }

    @Test
    void gettersShouldReturnConstructorValues() {
        StudentParticipant participant = new StudentParticipant(
                "stu-003",
                "Carla Dias",
                "carla@example.com",
                "Sistemas de Informação",
                2
        );

        assertEquals("stu-003", participant.getId());
        assertEquals("Carla Dias", participant.getFullName());
        assertEquals("carla@example.com", participant.getEmail());
    }
}
