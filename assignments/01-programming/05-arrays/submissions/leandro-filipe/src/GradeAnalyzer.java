import java.util.Locale;
import java.util.Scanner;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Utilizando Locale.US para garantir que números decimais sejam separados por ponto.
        scanner.useLocale(Locale.US);

        int numStudents = 0;

        // Validação da quantidade de estudantes
        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            numStudents = scanner.nextInt();
            if (numStudents > 0) {
                break;
            } else {
                System.out.println("Quantidade inválida. O número de estudantes deve ser maior que zero.");
            }
        }

        int[] grades = new int[numStudents];

        // Leitura e validação das notas
        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                int grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    grades[i] = grade;
                    break;
                } else {
                    System.out.println("Nota inválida. A nota deve estar entre 0 e 100.");
                }
            }
        }

        // Exibindo os resultados
        System.out.printf(Locale.US, "\nMédia da turma: %.2f\n", calculateAverage(grades));
        System.out.println("Maior nota: " + findHighestGrade(grades));
        System.out.println("Menor nota: " + findLowestGrade(grades));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(grades));

        System.out.println("\nDistribuição de notas:");
        int[] frequency = calculateFrequency(grades);
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
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
        int[] frequency = new int[11]; // 11 posições, do índice 0 ao 10

        for (int grade : grades) {
            if (grade == 100) {
                frequency[10]++;
            } else {
                int index = grade / 10;
                frequency[index]++;
            }
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        } else {
            int rangeStart = index * 10;
            int rangeEnd = rangeStart + 9;
            // %02d garante que os números de um dígito terão um zero à esquerda (ex: 00-09)
            return String.format("%02d-%02d: %d", rangeStart, rangeEnd, frequency);
        }
    }
}