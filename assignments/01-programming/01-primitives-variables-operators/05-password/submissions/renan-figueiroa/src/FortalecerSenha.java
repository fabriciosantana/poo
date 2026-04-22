import java.util.Random;
import java.util.Scanner;

public class FortalecerSenha {

    
    private static Scanner scanner = new Scanner(System.in);
    private static Random gerador = new Random();

    public static void main(String[] args) {
        String senhaOriginal;
        
        do {
            System.out.println("Digite a senha: ");
            senhaOriginal = scanner.nextLine();
            
            if (senhaOriginal.length() < 1) {
                System.out.println("Essa senha não atingiu a quantidade mínima de caracteres.");
            } else if (senhaOriginal.length() > 10) {
                System.out.println("Essa senha ultrapassou a quantidade máxima de caracteres.");
            }
        } while (senhaOriginal.length() > 10 || senhaOriginal.length() < 1);

        String senhaFortificada = fortalecerSenha(senhaOriginal);
        System.out.println("Senha fortalecida: " + senhaFortificada);
        
        calcularTempoDigitacao(senhaFortificada);
        
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder(s);

        // Usa o gerador global definido na linha 8
        int indiceLetra = gerador.nextInt(letras.length);
        int posicaoInsercao = gerador.nextInt(sb.length() + 1);

        char letraEscolhida = letras[indiceLetra];
        sb.insert(posicaoInsercao, letraEscolhida);

        return sb.toString();
    }

    public static int calcularTempoDigitacao(String s) {

        int tempoCalculado = 2; // primeiro caractere sempre custa 2
        for (int i = 1; i < s.length(); i++) {
            tempoCalculado += (s.charAt(i) == s.charAt(i - 1)) ? 1 : 2;
        }
        return tempoCalculado;
    }


}