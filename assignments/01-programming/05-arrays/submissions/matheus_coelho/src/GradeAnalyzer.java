import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum = sum + grades[i];
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
            int faixa = grades[i] / 10;
            frequency[faixa] = frequency[faixa] + 1;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        }
        int inicio = index * 10;
        int fim = inicio + 9;
        String linha = "";
        if (inicio < 10) {
            linha = "0" + inicio;
        } else {
            linha = "" + inicio;
        }
        linha = linha + "-" + fim + ": " + frequency;
        return linha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade = 0;
        do {
            System.out.print("Digite a quantidade de estudantes: ");
            quantidade = scanner.nextInt();
            if (quantidade <= 0) {
                System.out.println("A quantidade deve ser maior que zero.");
            }
        } while (quantidade <= 0);

        int[] grades = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            int nota = -1;
            do {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                nota = scanner.nextInt();
                if (nota < 0 || nota > 100) {
                    System.out.println("A nota deve estar entre 0 e 100.");
                }
            } while (nota < 0 || nota > 100);
            grades[i] = nota;
        }

        double media = calculateAverage(grades);
        int maior = findHighestGrade(grades);
        int menor = findLowestGrade(grades);
        int acimaDaMedia = countGradesAtOrAboveAverage(grades);
        int[] frequencia = calculateFrequency(grades);

        System.out.println("Média da turma: " + String.format("%.2f", media).replace(",", "."));
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Notas acima ou iguais à média: " + acimaDaMedia);
        System.out.println();
        System.out.println("Distribuição de notas:");
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }

        scanner.close();
    }
}
