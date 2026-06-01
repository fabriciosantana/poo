import java.util.Scanner;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicita quantidade de estudantes (validando > 0)
        int quantidade;
        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            quantidade = scanner.nextInt();
            if (quantidade > 0) break;
            System.out.println("A quantidade deve ser maior que zero.");
        }

        int[] notas = new int[quantidade];

        // 2. Leitura das notas (validando 0-100)
        for (int i = 0; i < quantidade; i++) {
            while (true) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                int nota = scanner.nextInt();
                if (nota >= 0 && nota <= 100) {
                    notas[i] = nota;
                    break;
                }
                System.out.println("Nota inválida. Digite um valor entre 0 e 100.");
            }
        }

        // 3. Exibição dos resultados
        double media = calculateAverage(notas);
        System.out.printf("%nMédia da turma: %.2f%n", media);
        System.out.println("Maior nota: " + findHighestGrade(notas));
        System.out.println("Menor nota: " + findLowestGrade(notas));
        System.out.println("Notas acima ou iguais à média: " + countGradesAtOrAboveAverage(notas));

        // 4. Exibição da distribuição
        System.out.println("\nDistribuição de notas:");
        int[] frequencia = calculateFrequency(notas);
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }

        scanner.close();
    }

    public static double calculateAverage(int[] grades) {
        int soma = 0;
        for (int grade : grades) soma += grade;
        return (double) soma / grades.length;
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
        double media = calculateAverage(grades);
        int count = 0;
        for (int grade : grades) if (grade >= media) count++;
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] freq = new int[11];
        for (int grade : grades) {
            if (grade == 100) {
                freq[10]++;
            } else {
                freq[grade / 10]++;
            }
        }
        return freq;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        } else {
            int inicio = index * 10;
            int fim = inicio + 9;
            return String.format("%02d-%02d: %d", inicio, fim, frequency);
        }
    }
}