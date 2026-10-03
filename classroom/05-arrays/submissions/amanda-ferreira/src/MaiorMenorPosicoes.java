import java.util.Formatter;

public class MaiorMenorPosicoes{
    public static void main(String[] agrs){
        int[] temperaturas = {23, 18, 26, 18, 21};
        int maior = 0;
        int menor = 0;

        if (temperaturas == null || temperaturas.length == 0) {
            System.err.println("SEM TEMPERATURAS");
            return;
        }

        for (int i = 0; i < temperaturas.length; i++){
            if(temperaturas[i] > temperaturas[maior]){
                maior = i;
            } else if(temperaturas[i] < temperaturas[menor]){
                menor = i;
            }
        }

        System.out.printf("Maior: %d (Indice %d)%nMenor: %d (Indice %d)%n", temperaturas[maior], maior, temperaturas[menor], menor);
    }
}