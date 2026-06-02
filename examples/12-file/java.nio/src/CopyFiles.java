import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFiles {
    public static void main(String[] args) {
        try {
            Path source = Path.of("data/hello.txt");
            Path target = Path.of("data/hello_copy.txt");

            Files.copy(source, target);
        } catch (IOException e) {
           Path log = Path.of("data/log.txt");
           String errorMessage = "Error copying file: " + e.getMessage();
           try{
            Files.write(log, errorMessage.getBytes());
           } catch (IOException ex) {
            System.err.println("Error writing to log file: " + ex.getMessage());
           }
        }
    }
}