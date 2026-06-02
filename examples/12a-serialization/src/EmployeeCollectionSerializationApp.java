import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCollectionSerializationApp {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Fabrico", "Santana", "123456"));
        employees.add(new Employee("Ana", "Souza", "987654"));
        employees.add(new Employee("Carlos", "Moura", "112233"));

        Path path = Path.of("data/employees.ser");

        try (OutputStream outputStream = Files.newOutputStream(path);
             ObjectOutputStream objectStream = new ObjectOutputStream(outputStream)) {

            objectStream.writeObject(employees);
            System.out.printf("Serializado %d empregados em %s%n", employees.size(), path);

        } catch (IOException ex) {
            System.out.printf("Erro ao serializar coleção de objetos: %s%n", ex);
        }
    }
}
