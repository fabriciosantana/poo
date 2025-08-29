import java.util.Scanner;

class FortalecerSenha {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String senhaOriginal;
        String senhaFortalecida;

        System.out.print("Digite a senha: ");
        senhaOriginal = ler.nextLine();

        if (senhaOriginal.length() >= 1 && senhaOriginal.length() <= 10) {
            senhaFortalecida = fortalecerSenha(senhaOriginal);

            System.out.println("Senha fortalecida: " + senhaFortalecida);
        } else {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
        }

        ler.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        // Loop 1: Itera sobre todas as posições possíveis para inserir um caractere
        for (int i = 0; i <= s.length(); i++) {
            
            // Loop 2: Itera sobre todos os caracteres de 'a' a 'z'
            for (char c = 'a'; c <= 'z'; c++) {
                
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String novaSenha = sb.toString();

                int tempoAtual = calcularTempoDigitacao(novaSenha);

                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        // Se a senha for vazia ou nula, o tempo é 0.
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        // O primeiro caractere sempre leva 2 segundos.
        int tempoTotal = 2;

        // Itera a partir do segundo caractere para comparar com o anterior
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1; // 1 segundo se for igual ao anterior
            } else {
                tempoTotal += 2; // 2 segundos se for diferente do anterior
            }
        }
        return tempoTotal;
    }
}