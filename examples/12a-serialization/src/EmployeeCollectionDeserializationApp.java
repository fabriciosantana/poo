import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmployeeCollectionDeserializationApp {

    public static void main(String[] args) {
        Path path = Path.of("data/employees.ser");

        try (InputStream inputStream = Files.newInputStream(path);
             ObjectInputStream objectStream = new ObjectInputStream(inputStream)) {

            @SuppressWarnings("unchecked")
            List<Employee> employees = (List<Employee>) objectStream.readObject();

            System.out.printf("Desserializado %d empregados de %s%n", employees.size(), path);
            employees.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException ex) {
            System.out.printf("Erro ao desserializar coleção de objetos: %s%n", ex);
        }
    }
}
