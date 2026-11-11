import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class HelloStudentFiles {
    public static void main(String[] args){

        Path file = Path.of("data/students.txt");
        //Path file = Path.of(args[0]);

        try{
            System.out.println("Usando java.nio.file.Files para ler arquivos");

            List<String> students = Files.readAllLines(file);
            Set<String> estudantesUnicos = new HashSet<>();

            estudantesUnicos.addAll(students);

            double somaNotas = 0.0;
            int qtdAlunos = students.size();
            double media = 0.0;
            
            for (String student : students) {
                
                String[] dados = student.split(",");

                String nome = dados[0];
                String nota = dados[1];

                somaNotas += Integer.parseInt(nota);

                System.out.println(nome + " - " + nota);
            }

            media = somaNotas / qtdAlunos;

            System.out.println("A média da turma é: " + media);

        } catch(IOException ex){
            System.out.printf("Error: %s%n", ex);
            ex.printStackTrace();
        }
    }   
}
