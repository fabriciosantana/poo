import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmployeeBinaryDeserializationApp {
    
    public static void main(String[] args) {
        
        try (InputStream inputStream = Files.newInputStream(Path.of("data/employee.ser"))){

            ObjectInputStream objectStream = new ObjectInputStream(inputStream);

            Employee e = (Employee) objectStream.readObject();
            
            System.out.println(e);
           
        } catch(IOException | ClassNotFoundException ex){
            System.out.printf("Erro ao deserializar objeto: %s%n", ex);
        }
    }
    
}
