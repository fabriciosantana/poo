import java.util.Scanner;


public class PassosElefante{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 
        boolean maximo_posicoes; 
        int passos;
        do {
            System.out.println("Digite a posição da casa do amigo:");
            passos = scanner.nextInt();

        if (1 <= passos && passos <= 1000000) {
            maximo_posicoes = true;
         } else {
            System.out.println("Valor inválido! Tente novamente.");
            maximo_posicoes = false;
        }
        } while (!maximo_posicoes);


        
        int Qtd_passos = calcularPassosMinimos(passos);
        String saida = formatarSaida(Qtd_passos);

        System.out.println(saida);

    }

    public static int calcularPassosMinimos(int x){

            int Qtd_passo;
            
            if(x%5 == 0){
                Qtd_passo = x/5;
            } else{
                Qtd_passo = x/5 +1;
            }

            return Qtd_passo;
    }

    public static String formatarSaida(int q){

        String texto_saida = String.format("O número mínimo de passos necessários é: %d", q);

        return texto_saida;
    }
}