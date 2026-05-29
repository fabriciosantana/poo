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
            return "100: " + frequency;
        }

        return String.format("%02d-%02d: %d", index * 10, index * 10 + 9, frequency);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a quantidade de estudantes: ");
        int quantity = input.nextInt();

        while (quantity <= 0) {
            System.out.print("Quantidade inválida. Digite novamente: ");
            quantity = input.nextInt();
        }

        int[] grades = new int[quantity];

        for (int i = 0; i < grades.length; i++) {
            System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
            int grade = input.nextInt();

            while (grade < 0 || grade > 100) {
                System.out.print("Nota inválida. Digite novamente: ");
                grade = input.nextInt();
            }

            grades[i] = grade;
        }

        System.out.printf("Média da turma: %.2f%n", calculateAverage(grades));
        System.out.println("Maior nota: " + findHighestGrade(grades));
        System.out.println("Menor nota: " + findLowestGrade(grades));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(grades));

        System.out.println();
        System.out.println("Distribuição de notas:");

        int[] frequency = calculateFrequency(grades);

        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        input.close();
    }
}