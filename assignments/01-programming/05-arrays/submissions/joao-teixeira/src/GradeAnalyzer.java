import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        double soma = 0;
        for (int nota : grades) {
            soma += nota;
        }
        return soma / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int maior = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > maior) {
                maior = grades[i];
            }
        }
        return maior;
    }

    public static int findLowestGrade(int[] grades) {
        int menor = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < menor) {
                menor = grades[i];
            }
        }
        return menor;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double media = calculateAverage(grades);
        int count = 0;
        for (int nota : grades) {
            if (nota >= media) {
                count++;
            }
        }
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequencia = new int[11];
        for (int nota : grades) {
            if (nota == 100) {
                frequencia[10]++;
            } else {
                frequencia[nota / 10]++;
            }
        }
        return frequencia;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        }
        return String.format("%02d-%02d: %d", index * 10, index * 10 + 9, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade;
        do {
            System.out.print("Digite a quantidade de estudantes: ");
            quantidade = scanner.nextInt();
        } while (quantidade <= 0);

        int[] notas = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            int nota;
            do {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                nota = scanner.nextInt();
            } while (nota < 0 || nota > 100);
            notas[i] = nota;
        }

        double media = calculateAverage(notas);
        int maior = findHighestGrade(notas);
        int menor = findLowestGrade(notas);
        int acimaMedia = countGradesAtOrAboveAverage(notas);
        int[] frequencia = calculateFrequency(notas);

        System.out.printf("Média da turma: %.2f%n", media);
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Notas acima ou iguais à média: " + acimaMedia);
        System.out.println();
        System.out.println("Distribuição de notas:");

        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }

        scanner.close();
    }
}
