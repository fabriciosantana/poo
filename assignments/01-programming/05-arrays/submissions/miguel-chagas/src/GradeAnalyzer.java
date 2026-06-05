import java.util.Scanner;
import java.util.Locale;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0;
        }
        int highest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0;
        }
        int lowest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0;
        }
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
        if (grades == null) {
            return frequency;
        }
        for (int grade : grades) {
            if (grade == 100) {
                frequency[10]++;
            } else {
                frequency[grade / 10]++;
            }
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        } else {
            int start = index * 10;
            int end = start + 9;
            return String.format(Locale.US, "%02d-%02d: %d", start, end, frequency);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = 0;

        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                if (numStudents > 0) {
                    break;
                }
            } else {
                scanner.next(); // consume invalid token
            }
        }

        int[] grades = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades[i] = grade;
                        break;
                    }
                } else {
                    scanner.next(); // consume invalid token
                }
            }
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int aboveOrEqual = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf(Locale.US, "Média da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highest);
        System.out.println("Menor nota: " + lowest);
        System.out.println("Notas acima ou iguais à média: " + aboveOrEqual);
        System.out.println();
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }
}
