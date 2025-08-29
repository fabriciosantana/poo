import java.util.Scanner;

/**
 * A classe FortalecerSenha recebe uma senha, insere uma letra minúscula
 * em uma posição estratégica para maximizar o tempo de digitação e retorna
 * a nova senha fortalecida.
 */
public class FortalecerSenha {

    /**
     * O método principal (main) é o ponto de entrada do programa.
     * Ele solicita a senha, valida a entrada, e chama os métodos
     * para fortalecer a senha e exibir o resultado.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        scanner.close();

        // Requisito de validação: 1 <= |s| <= 10 e apenas letras minúsculas.
        if (senhaOriginal.length() >= 1 && senhaOriginal.length() <= 10 && senhaOriginal.matches("[a-z]+")) {
            String senhaFortalecida = fortalecerSenha(senhaOriginal);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        } else {
            System.out.println("Erro: A senha deve ter entre 1 e 10 caracteres e conter apenas letras minúsculas (a-z).");
        }
    }

    /**
     * Encontra a melhor senha testando a inserção de cada letra ('a'-'z')
     * em cada posição possível da senha original.
     *
     * @param s A senha original.
     * @return A nova senha com o maior tempo de digitação possível.
     */
    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1; // Inicia com um tempo mínimo para garantir a primeira atribuição.

        // Loop 1: Itera por todas as posições de inserção possíveis.
        // Se a senha tem tamanho N, há N+1 posições para inserir (0 a N).
        for (int i = 0; i <= s.length(); i++) {
            // Loop 2: Itera por todas as letras do alfabeto.
            for (char charParaInserir = 'a'; charParaInserir <= 'z'; charParaInserir++) {
                // Monta a nova senha candidata usando StringBuilder para eficiência.
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, charParaInserir);
                String novaSenha = sb.toString();

                // Calcula o tempo de digitação da nova senha.
                int tempoAtual = calcularTempoDigitacao(novaSenha);

                // Se o tempo da senha atual for o maior encontrado até agora,
                // atualizamos a melhor senha e o tempo máximo.
                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    /**
     * Calcula o tempo de digitação de uma senha com base nas regras especificadas.
     *
     * @param senha A senha para a qual o tempo será calculado.
     * @return O tempo total de digitação em segundos (int).
     */
    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        // O primeiro caractere sempre leva 2 segundos.
        int tempoTotal = 2;

        // Itera a partir do segundo caractere para comparar com o anterior.
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1; // 1 segundo se for igual ao anterior.
            } else {
                tempoTotal += 2; // 2 segundos se for diferente do anterior.
            }
        }
        return tempoTotal;
    }
}