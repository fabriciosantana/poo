import java.util.Scanner;

public class GradeAnalyzer {

    // calcular a média
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return (double) sum / grades.length;
    }

    // maior nota
    public static double findHighestGrade(int[] grades) {
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    // menor nota
    public static double findLowestGrade(int[] grades) {
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    // quantidade de notas acima ou iguais à média
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

    // distribuição de notas
    public static int[] calculateFrequency(int[] grades) {
        int[] frequency = new int[11];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade >= 0 && grade <= 100) {
                frequency[grade / 10]++;
            }
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return String.format("100: %d", frequency);
        }
        return String.format("%d-%d: %d", index * 10, index * 10 + 9, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // receber a quantidade de estudantes
        int numStudents = 0;
        do {
            System.out.print("Digite a quantidade de estudantes: ");
            numStudents = scanner.nextInt();
            if (numStudents <= 0) {
                System.out.println("A quantidade de estudantes deve ser maior que zero.");
            }
        } while (numStudents <= 0);

        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            do {
                System.out.printf("Digite a nota do estudante %d: ", i + 1);
                grades[i] = scanner.nextInt();
                if (grades[i] < 0 || grades[i] > 100) {
                    System.out.println("As notas devem estar entre 0 e 100. Por favor, digite novamente.");
                }
            } while (grades[i] < 0 || grades[i] > 100);
        }

        System.out.printf("%nMédia da turma: %.2f%n", calculateAverage(grades));
        System.out.printf("Maior nota: %.2f%n", findHighestGrade(grades));
        System.out.printf("Menor nota: %.2f%n", findLowestGrade(grades));
        System.out.printf("Notas acima ou iguais à média: %d%n%n", countGradesAtOrAboveAverage(grades));
        System.out.println("Distribuição de notas:");

        int[] frequencia = calculateFrequency(grades);

        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }
    }
}