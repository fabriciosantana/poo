import java.util.Scanner;

public class FortalecerSenha {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senha = scanner.next();
        scanner.close();
        
        // Verifica se a senha atende às restrições de tamanho
        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
            return;
        }

        // Se a senha já tiver 10 caracteres, não é possível fortalecer
        if (senha.length() == 10) {
            System.out.println("A senha já possui o tamanho máximo permitido.");
            return;
        }

        // Verifica se a senha contém apenas letras minúsculas
        if (!senha.matches("[a-z]+")) {
            System.out.println("A senha deve conter apenas letras minúsculas.");
            return;
        }
        
        // Fortalece a senha encontrando a melhor inserção de caractere
        String senhaFortalecida = fortalecerSenha(senha);
        
        // Calcula o tempo de digitação
        int tempo = calcularTempoDigitacao(senhaFortalecida);
        
        // Exibe o resultado
        System.out.println("Senha fortalecida: " + senhaFortalecida);
        System.out.println("Tempo de digitação: " + tempo + " segundos");
    }

    // Método para fortalecer a senha
    public static String fortalecerSenha(String s) {
        String melhorSenha = null;
        int maxTempo = 0;

        // Testa todas as posições possíveis para inserção de uma nova letra
        for (int i = 0; i <= s.length(); i++) {
            // Testa todas as letras possíveis (a-z)
            for (char c = 'a'; c <= 'z'; c++) {
                // Cria uma nova senha inserindo a letra `c` na posição `i`
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                
                // Calcula o tempo de digitação da nova senha
                int tempo = calcularTempoDigitacao(novaSenha);

                // Mantém a senha que maximiza o tempo
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    // Método para calcular o tempo de digitação
    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;
        
        int tempo = 2; // O primeiro caractere sempre leva 2 segundos
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }
}
