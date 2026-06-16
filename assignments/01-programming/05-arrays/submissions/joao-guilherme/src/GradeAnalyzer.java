import java.util.Locale;
import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
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
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= average) {
                count++;
            }
        }
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequency = new int[11];
        for (int i = 0; i < grades.length; i++) {
            frequency[grades[i] / 10]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        }
        int lower = index * 10;
        int upper = lower + 9;
        return String.format("%02d-%02d: %d", lower, upper, frequency);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a quantidade de estudantes: ");
        int numberOfStudents = input.nextInt();
        while (numberOfStudents <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            numberOfStudents = input.nextInt();
        }

        int[] grades = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
            int grade = input.nextInt();
            while (grade < 0 || grade > 100) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                grade = input.nextInt();
            }
            grades[i] = grade;
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int countAtOrAboveAverage = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf(Locale.US, "Média da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highest);
        System.out.println("Menor nota: " + lowest);
        System.out.println("Notas acima ou iguais à média: " + countAtOrAboveAverage);
        System.out.println();
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        input.close();
    }
}