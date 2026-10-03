import java.util.Formatter;

public class SomaMedia{
    public static void main(String[] agrs){
        int[] notas = {8, 6, 10, 7, 9};
        int total = 0;

        if (notas == null || notas.length == 0) {
            System.err.println("SEM NOTAS");
            return;
        }

        for (int nota : notas) {
            total += nota;
        }

        double media = (double) total / notas.length;
        System.out.printf("Soma: %d%nMédia: %.1f%n", total, media);
    }
}