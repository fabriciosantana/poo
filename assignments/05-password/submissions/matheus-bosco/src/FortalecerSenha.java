import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        if (!senhaValida(senhaOriginal)){
            System.out.println("Senha inválida. Deve conter entre 1 e 10 letras minúsculas (a-z).");
            scanner.close();
            return;
        }

        String senhaFortalecida = fortalecerSenha(senhaOriginal);  //STRING SENHA FORTALECIDA GRAÇAS A FUNÇÃO 

        String saida = formatarSaida(senhaFortalecida); //STRING SAIDA GRAÇAS A FORMATAR SAIDA
        
        System.out.print(saida);

        scanner.close();
    }


     public static boolean senhaValida(String senha) {  //DEFINE O QUE É UMA SENHA VÁLIDA
        return senha.matches("[a-z]{1,10}");
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int tempoMaximo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);
                if (tempo > tempoMaximo) {
                    tempoMaximo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;

        int tempo = 2; // Primeiro caractere
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }

        return tempo;
    }

    public static String formatarSaida(String senhaFortalecida) {
        return String.format("Senha fortalecida: %s", senhaFortalecida);
    }
}

