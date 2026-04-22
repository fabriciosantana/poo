import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class RentalReportAppTest {

    @Test
    void shouldGenerateCsvWhenCalledWith150() throws Exception {
        RentalReportApp.main(new String[]{"150"});

        assertTrue(Files.exists(Path.of("rentals.csv")));
    }

    @AfterEach
    void deleteFile() throws Exception {
        Files.delete(Path.of("rentals.csv"));
    }
}
