import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventAppTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream buffer;

    @BeforeEach
    void setUpStreams() {
        originalOut = System.out;
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void mainShouldDisplaySampleParticipants() {
        EventApp.main(new String[0]);

        String output = buffer.toString();

        assertTrue(output.contains("Participantes cadastrados"));
        assertTrue(output.contains("Estudante"));
        assertTrue(output.contains("Profissional"));
    }
}
