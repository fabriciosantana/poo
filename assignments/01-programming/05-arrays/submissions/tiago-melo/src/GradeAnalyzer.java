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
        int highestGrade = grades[0];

        for (int grade : grades) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
        }

        return highestGrade;
    }

    public static int findLowestGrade(int[] grades) {
        int lowestGrade = grades[0];

        for (int grade : grades) {
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }

        return lowestGrade;
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
        }

        int start = index * 10;
        int end = start + 9;

        return String.format("%02d-%02d: %d", start, end, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = readStudentCount(scanner);
        int[] grades = new int[studentCount];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = readGrade(scanner, i + 1);
        }

        double average = calculateAverage(grades);
        int highestGrade = findHighestGrade(grades);
        int lowestGrade = findLowestGrade(grades);
        int gradesAtOrAboveAverage = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf(Locale.US, "Media da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highestGrade);
        System.out.println("Menor nota: " + lowestGrade);
        System.out.println("Notas acima ou iguais a media: " + gradesAtOrAboveAverage);
        System.out.println();
        System.out.println("Distribuicao de notas:");

        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }

    private static int readStudentCount(Scanner scanner) {
        int studentCount;

        do {
            System.out.print("Digite a quantidade de estudantes: ");
            studentCount = scanner.nextInt();
        } while (studentCount <= 0);

        return studentCount;
    }

    private static int readGrade(Scanner scanner, int studentNumber) {
        int grade;

        do {
            System.out.print("Digite a nota do estudante " + studentNumber + ": ");
            grade = scanner.nextInt();
        } while (grade < 0 || grade > 100);

        return grade;
    }
}
