import java.util.Locale;
import java.util.Scanner;


public class GradeAnalyzer {

  
    public static double calculateAverage(int[] grades) {
        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.length;
    }


    public static int findHighestGrade(int[] grades) {
        int highest = grades[0];

        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    
    public static int findLowestGrade(int[] grades) {
        int lowest = grades[0];

        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
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
            return String.format("100: %d", frequency);
        }

        int start = index * 10;
        int end = start + 9;

        return String.format("%02d-%02d: %d", start, end, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = readStudentCount(scanner);
        int[] grades = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            grades[i] = readGrade(scanner, i + 1);
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int aboveAverage = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf(Locale.US, "Média da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highest);
        System.out.println("Menor nota: " + lowest);
        System.out.println("Notas acima ou iguais à média: " + aboveAverage);
        System.out.println();
        System.out.println("Distribuição de notas:");

        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }

 
    private static int readStudentCount(Scanner scanner) {
        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Informe um número inteiro.");
                scanner.next();
                continue;
            }

            int value = scanner.nextInt();

            if (value > 0) {
                return value;
            }

            System.out.println("A quantidade de estudantes deve ser maior que zero.");
        }
    }

    
    private static int readGrade(Scanner scanner, int studentNumber) {
        while (true) {
            System.out.print("Digite a nota do estudante " + studentNumber + ": ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Informe um número inteiro.");
                scanner.next();
                continue;
            }

            int grade = scanner.nextInt();

            if (grade >= 0 && grade <= 100) {
                return grade;
            }

            System.out.println("A nota deve estar entre 0 e 100.");
        }
    }
}
