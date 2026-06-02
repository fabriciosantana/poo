import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HelloStudentWithScanner {
    public static void main(String[] args){

        //Path file = Path.of("data/students.txt");
        Path file = Path.of(args[0]);

        try(Scanner input = new Scanner(file)){

            while(input.hasNext()){
                String name = input.nextLine();
            
                System.out.printf("Hello, %s%n", name);
            }
        } catch(IOException ex){
            System.out.printf("Error: %s", ex.toString());
        }
    }
}
