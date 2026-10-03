public class Busca{
    private static int buscar(int[] valores, int alvo){
        for(int i = 0; i < valores.length; i++){
            if (valores[i] == alvo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int [] valores = {4, 7, 4, 9};

        System.out.println(buscar(valores, 4));
        System.out.println(buscar(valores, 9));
        System.out.println(buscar(valores, 5));
    }
}