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
            int index = grade / 10;
            frequency[index]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return String.format("100: %d", frequency);
        }
        return String.format("%02d-%02d: %d", index * 10, index * 10 + 9, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = 0;
        while (studentCount <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                studentCount = scanner.nextInt();
                if (studentCount <= 0) {
                    System.out.println("Erro: a quantidade deve ser maior que zero.");
                }
            } else {
                System.out.println("Erro: digite um número inteiro válido.");
                scanner.next();
            }
        }

        int[] grades = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            int grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    grade = scanner.nextInt();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Erro: a nota deve estar entre 0 e 100.");
                    }
                } else {
                    System.out.println("Erro: digite um número inteiro válido.");
                    scanner.next();
                }
            }
            grades[i] = grade;
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int aboveAvg = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf("%n%nMédia da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highest);
        System.out.println("Menor nota: " + lowest);
        System.out.println("Notas acima ou iguais à média: " + aboveAvg);

        System.out.println();
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }
}
