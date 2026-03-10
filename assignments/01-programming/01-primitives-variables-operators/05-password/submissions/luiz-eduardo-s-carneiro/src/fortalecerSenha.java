import java.util.Scanner;

public class FortalecerSenha{

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite a senha: ");
        String old_pass = scanner.next();

        System.out.println("Senha fortalecida: " + fortalecerSenha(old_pass));
        
    }

    public static String fortalecerSenha(String s){

        String new_pass = "";
        int max_time = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char letra = 'a'; letra <= 'z'; letra ++) {
                
                String possible_new_pass = s.substring(0, i) + letra + s.substring(i);
                
                int time_now = calcularTempoDigitacao(possible_new_pass);

                if(time_now > max_time){
                    max_time = time_now;
                    new_pass = possible_new_pass;
                }
            }
        }
        return new_pass;
    }

    public static int calcularTempoDigitacao(String possible_new_pass){
        int time_now = 2;

        for(int i = 1; i < possible_new_pass.length(); i++){
            if(possible_new_pass.charAt(i) == possible_new_pass.charAt(i-1)){
                time_now += 1;
            } else {
                time_now += 2;
            }
        }
        return time_now;
    }
}