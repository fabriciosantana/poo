import java.util.Arrays;
import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int sum = 0;

        for(int grade: grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int highest = grades[0];

        for(int grade: grades) {
            if(grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        int lowest = grades[0];

        for(int grade: grades) {
            if(grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double average = calculateAverage(grades);
        int count = 0;

        for(int grade: grades) {
            if(grade >= average) {
                count++;
            }
        }
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequency = new int[11];
        for(int grade: grades) {
            if(grade == 100){
                frequency[10]++;
            } else {
                frequency[grade / 10]++;
            }
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if(index == 10) {
            return String.format("100: %d", frequency);
        }
        
        int lower = index * 10;
        int upper = lower + 9;

        return String.format("%02d-%02d: %d", lower, upper, frequency);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de estudantes: ");
        int qtdEstudantes = sc.nextInt();

        int[] grades = new int[qtdEstudantes];
        for (int i = 0; i < qtdEstudantes; i++) {
            System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
            grades[i] = sc.nextInt();
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int countAboveAverage = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf("Média da turma: %.2f%n", average);
        System.out.printf("Maior nota: %d%n", highest);
        System.out.printf("Menor nota: %d%n", lowest);
        System.out.printf("Notas acima ou iguais à média: %d%n", countAboveAverage);
        System.out.println();
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }
        sc.close();
    }
}