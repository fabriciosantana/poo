public class Frequencia{
    public static void main(String[] agrs){
        int[] resultados = {1, 3, 2, 1, 6, 3, 1};
        int contador_invalidos = 0;
        int [] contador_face = new int [6];

        for (int resultado : resultados) {
            if(resultado > 6 || resultado < 1){
                contador_invalidos++;
                continue;
            }
            contador_face[resultado - 1]++;
        }

        for (int i = 0; i < contador_face.length; i++) {
            System.out.println((i + 1) + ": " + String.valueOf('*').repeat(contador_face[i]));
        }

        System.err.println("Ignorados: " + contador_invalidos);
    }
}