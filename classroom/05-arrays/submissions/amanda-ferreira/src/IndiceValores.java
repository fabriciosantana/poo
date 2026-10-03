import java.util.Formatter;

public class IndiceValores{
    public static void main(String[] agrs){
        int [] valores = {32, 27, 64, 18, 95};

        System.out.printf("%5s %8s%n", "Índice", "Valor");
        for(int i = 0; i <  valores.length; i++){
            System.out.printf("%5d %8d%n", i, valores[i]);
        }

        System.out.println("Tamanho: " + valores.length);
        System.out.println("Último: " + valores[valores.length - 1]);
    }
}