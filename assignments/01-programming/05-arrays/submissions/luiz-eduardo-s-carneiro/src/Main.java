import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GradeAnalyzer ga = new GradeAnalyzer();
        
        System.out.print("Digite a quantidade de estudantes: ");
        int qnd = scanner.nextInt();

        int[] grades = new int[qnd];

        for(int i = 0; i < grades.length; i++){
            System.out.printf("Digite a nota do estudante %d: ", i + 1);
            grades[i] = scanner.nextInt();
        }

        System.out.printf("\nMédia da turma: %.2f", ga.calculateAverage(grades));
        System.out.printf("\nMaior nota: %d", ga.findHighestGrade(grades));
        System.out.printf("\nMenor nota: %d", ga.findLowestGrade(grades));
        System.out.printf("\nNotas acima ou iguais à média: %d", ga.countGradesAtOrAboveAverage(grades));

        System.out.println("\n\nDistribuição de notas:");
        int[] frequency = ga.calculateFrequency(grades);
        
        for(int i = 0; i < frequency.length; i++){
                System.out.println(ga.formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }
}