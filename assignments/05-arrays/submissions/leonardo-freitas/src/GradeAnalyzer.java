import java.util.Scanner;

public class GradeAnalyzer {
    private static void validateGrades(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("O array de notas deve conter pelo menos uma nota.");
        }
        for (int grade : grades) {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("As notas devem estar entre 0 e 100.");
            }
        }
    }

    public static double calculateAverage(int[] grades) {
        validateGrades(grades);
        long sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        validateGrades(grades);
        int highest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        validateGrades(grades);
        int lowest = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        validateGrades(grades);
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
        validateGrades(grades);
        int[] frequency = new int[11];
        for (int grade : grades) {
            frequency[grade / 10]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index < 0 || index > 10) {
            throw new IllegalArgumentException("Índice de frequência inválido.");
        }
        if (index == 10) {
            return "100: " + frequency;
        }
        int start = index * 10;
        int end = start + 9;
        return String.format("%02d-%02d: %d", start, end, frequency);
    }

    private static int readPositiveStudentCount(Scanner scanner) {
        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                if (count > 0) {
                    return count;
                }
            } else {
                scanner.next();
            }
            System.out.println("Valor inválido. Informe um inteiro maior que zero.");
        }
    }

    private static int readGrade(Scanner scanner, int studentNumber) {
        while (true) {
            System.out.print("Digite a nota do estudante " + studentNumber + ": ");
            if (scanner.hasNextInt()) {
                int grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    return grade;
                }
            } else {
                scanner.next();
            }
            System.out.println("Nota inválida. Informe um inteiro entre 0 e 100.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = readPositiveStudentCount(scanner);
        int[] grades = new int[studentCount];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = readGrade(scanner, i + 1);
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
    }
}
