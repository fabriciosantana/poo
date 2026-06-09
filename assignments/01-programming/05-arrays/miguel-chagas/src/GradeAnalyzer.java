import java.util.Scanner;
import java.util.Locale;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        if (grades.length == 0) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        if (grades.length == 0) return 0;
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        if (grades.length == 0) return 0;
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
            return String.format("%02d-%02d: %d", index * 10, index * 10 + 9, frequency);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfStudents = 0;
        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                numberOfStudents = scanner.nextInt();
                if (numberOfStudents > 0) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            // Exige quantidade > 0 como pede o README
            // "Caso uma entrada inválida seja informada, o programa deve solicitar novamente o valor."
        }
        
        int[] grades = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            while (true) {
                System.out.printf("Digite a nota do estudante %d: ", i + 1);
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades[i] = grade;
                        break;
                    }
                } else {
                    scanner.next(); // Consume invalid input
                }
            }
        }
        
        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int aboveOrEqualAvg = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);
        
        System.out.printf(Locale.US, "Média da turma: %.2f\n", average);
        System.out.printf("Maior nota: %d\n", highest);
        System.out.printf("Menor nota: %d\n", lowest);
        System.out.printf("Notas acima ou iguais à média: %d\n\n", aboveOrEqualAvg);
        
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }
        
        scanner.close();
    }
}
