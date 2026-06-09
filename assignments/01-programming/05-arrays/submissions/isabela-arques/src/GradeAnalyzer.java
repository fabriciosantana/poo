import java.util.Locale;
import java.util.Scanner;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int numStudents = 0;
        
        while (numStudents <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                if (numStudents <= 0) {
                    System.out.println("Quantidade inválida. O valor deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }

        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            int grade = -1;
            
            while (grade < 0 || grade > 100) {
                System.out.printf("Digite a nota do estudante %d: ", (i + 1));
                if (scanner.hasNextInt()) {
                    grade = scanner.nextInt();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Nota inválida. A nota deve estar entre 0 e 100.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            }
            grades[i] = grade;
        }

        System.out.printf(Locale.US, "\nMédia da turma: %.2f\n", calculateAverage(grades));
        System.out.println("Maior nota: " + findHighestGrade(grades));
        System.out.println("Menor nota: " + findLowestGrade(grades));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(grades));

        System.out.println("\nDistribuição de notas:");
        int[] frequencies = calculateFrequency(grades);
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencies[i]));
        }

        scanner.close();
    }

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int highest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        int lowest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double average = calculateAverage(grades);
        int count = 0;
        for (int grade : grades) {
            if (grade >= average) {
                count++;
            }
        }
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequency = new int[11];
        for (int grade : grades) {
            frequency[grade / 10]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        } else {
            int rangeStart = index * 10;
            int rangeEnd = rangeStart + 9;
            return String.format("%02d-%02d: %d", rangeStart, rangeEnd, frequency);
        }
    }
}