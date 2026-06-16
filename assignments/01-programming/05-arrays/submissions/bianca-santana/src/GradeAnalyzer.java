import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int max = grades[0];
        for (int grade : grades) if (grade > max) max = grade;
        return max;
    }

    public static int findLowestGrade(int[] grades) {
        int min = grades[0];
        for (int grade : grades) if (grade < min) min = grade;
        return min;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double avg = calculateAverage(grades);
        int count = 0;
        for (int grade : grades) if (grade >= avg) count++;
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] freq = new int[11];
        for (int grade : grades) {
            if (grade == 100) freq[10]++;
            else freq[grade / 10]++;
        }
        return freq;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) return "100: " + frequency;
        int low = index * 10;
        int high = low + 9;
        return String.format("%02d-%02d: %d", low, high, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        while (n <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            try { n = Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) {}
            if (n <= 0) System.out.println("Quantidade inválida. Tente novamente.");
        }

        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            int grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                try { grade = Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) {}
                if (grade < 0 || grade > 100) System.out.println("Nota inválida. Digite um valor entre 0 e 100.");
            }
            grades[i] = grade;
        }

        System.out.printf("Média da turma: %.2f%n", calculateAverage(grades));
        System.out.println("Maior nota: " + findHighestGrade(grades));
        System.out.println("Menor nota: " + findLowestGrade(grades));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(grades));

        System.out.println("\nDistribuição de notas:");
        int[] freq = calculateFrequency(grades);
        for (int i = 0; i <= 10; i++) {
            System.out.println(formatFrequencyLine(i, freq[i]));
        }

        scanner.close();
    }
}
