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
            // 100 / 10 = 10, entao a nota maxima cai sozinha no ultimo indice
            frequency[grades[i] / 10]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        }
        int start = index * 10;
        return String.format(Locale.US, "%02d-%02d: %d", start, start + 9, frequency);
    }

    private static int readIntInRange(Scanner scanner, String prompt, int min, int max, String invalidMessage) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                // descarta o token nao numerico para nao repetir o mesmo erro para sempre
                scanner.next();
            }
            System.out.println(invalidMessage);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = readIntInRange(scanner, "Digite a quantidade de estudantes: ", 1, Integer.MAX_VALUE,
                "Quantidade inválida. Informe um número inteiro maior que zero.");

        int[] grades = new int[studentCount];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = readIntInRange(scanner, "Digite a nota do estudante " + (i + 1) + ": ", 0, 100,
                    "Nota inválida. Informe um número inteiro entre 0 e 100.");
        }

        System.out.printf(Locale.US, "Média da turma: %.2f%n", calculateAverage(grades));
        System.out.println("Maior nota: " + findHighestGrade(grades));
        System.out.println("Menor nota: " + findLowestGrade(grades));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(grades));

        System.out.println();
        System.out.println("Distribuição de notas:");
        int[] frequency = calculateFrequency(grades);
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }
}
