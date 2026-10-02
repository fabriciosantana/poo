import java.util.Locale;

public class EstatisticasTurma {

    public static void main(String[] args) {
        int[] notas = {10, 8, -1, 6, 4, 11, 7};

        int validas = 0;
        int invalidas = 0;
        int somaValidas = 0;
        int conceitoA = 0;
        int conceitoB = 0;
        int conceitoC = 0;
        int conceitoD = 0;

        for (int nota : notas) {
            if (nota < 0 || nota > 10) {
                invalidas++;
                continue;
            }

            validas++;
            somaValidas += nota;

            switch (nota) {
                case 9, 10 -> conceitoA++;
                case 7, 8 -> conceitoB++;
                case 5, 6 -> conceitoC++;
                case 0, 1, 2, 3, 4 -> conceitoD++;
            }
        }

        double media;
        if (validas > 0) {
            media = (double) somaValidas / validas;
        } else {
            media = 0;
        }

        System.out.println("Válidas: " + validas);
        System.out.println("Inválidas: " + invalidas);
        System.out.printf(Locale.US, "Média: %.2f%n", media);
        System.out.println("A: " + conceitoA);
        System.out.println("B: " + conceitoB);
        System.out.println("C: " + conceitoC);
        System.out.println("D: " + conceitoD);
    }
}
