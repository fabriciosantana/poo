import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();
            
            if (senha.length() < 1 || senha.length() > 10 || !senha.matches("[a-z]+")) {
                System.out.println("A senha deve ter entre 1 e 10 caracteres e conter apenas letras minúsculas (a-z).");
                return;
            }
            
            String senhaFortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        }
    }
    
    public static String fortalecerSenha(String s) {
        String melhorSenha = s;
        int maiorTempo = calcularTempoDigitacao(s);
        
        
        for (int i = 0; i <= s.length(); i++) {
            
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);
                
                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }
        
        return melhorSenha;
    }
    
    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;
        
        int tempoTotal = 2; 
        
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i-1)) {
                tempoTotal += 1;
            } else {
                tempoTotal += 2;
            }
        }
        
        return tempoTotal;
    }
}