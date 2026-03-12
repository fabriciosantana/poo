import java.util.Random;
import java.util.Scanner;
public class FortalecerSenha {
    public static String fortalecerSenha(String s){  
    //Randomizar uma letra do alfabeto e colocar na senha até o máximo de caracteres permitido
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        char letraAleatoria = alfabeto.charAt(random.nextInt(alfabeto.length()));
        System.out.println("Letra Escolhida: "+ letraAleatoria);
        int randomIndex = random.nextInt(s.length() +1);

        StringBuilder sb = new StringBuilder(s);
        sb.insert(randomIndex, letraAleatoria);
        return sb.toString();
    }
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = scanner.nextLine();
        
        //s.leght() -> verifica o tamanho da String s e compara comsa os valores mínimo e máximo definidos. 
        if (s.length() >= 1 && s.length() <= 10) {
        } else {
        System.out.println("String inválida. O tamanho deve ser entre 1 e 10 caracteres.");
        return;
        }

        String senhafortalecida = fortalecerSenha(s);
        System.out.println("Senha Original: "+ s);
        System.out.println("Nova Senha: " + senhafortalecida);
        int tempoDigitacao = calcularTempoDigitacao(senhafortalecida);
        System.out.println("Tempo para digitar a senha: " + tempoDigitacao + " segundos");
    }

    public static int calcularTempoDigitacao(String s) {
        int tempo = 2; // primeira letra da senha

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}
/*
public static String fortalecerSenha(String s){   
        String senhaforte = s;
        Random random = new Random();
        
        StringBuilder sb = new StringBuilder(senhaforte);

        sb.insert(random.nextInt(sb.length() + 1), (char) ('a' + random.nextInt(26)));
        senhaforte = sb.toString();

        System.out.println("Senha Fortalecida: " + senhaforte);
        return senhaforte;
*/
