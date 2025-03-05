import java.util.Scanner;

public class FortalecerSenha{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        if(senha.length() < 1 || senha.length() > 10){
            System.out.println("A senha deve ter entre 1 e 10 caracteres");
            scanner.close();
            return;
        }

        String senhaForte  = fortalecerSenha(senha);

        System.out.println("Senha fortalecida: " + senhaForte);

        scanner.close();
    }

    public static String fortalecerSenha(String s){
        char[] melhorSenha = s.toCharArray();
        int maiorTempo = calcularTempoDigitacao(s);
        String senhaFinal = s;

    for (int i =0; i <= s.length();i++){
        for (char c='a'; c<= 'z'; c++){
            char[] novaSenha = new char[s.length() + 1];
            int k = 0;
            for (int j = 0; j < novaSenha.length; j++){
                if (j==i){
                    novaSenha[j] = c;
                }else{
                    novaSenha[j] = s.charAt(k);
                    k++;
                }
            }

            String novaSenhaString = new String(novaSenha);
            int tempo = calcularTempoDigitacao(novaSenhaString);

            if(tempo > maiorTempo){
                maiorTempo = tempo;
                senhaFinal = novaSenhaString;
            }

        }

    }
    return senhaFinal;
  }

  public static int calcularTempoDigitacao(String senha){
    int tempo = 2;

    for (int i = 1; i < senha.length(); i++){
        if (senha.charAt(i) == senha.charAt(i - 1)){
            tempo += 1;
        }else{
            tempo += 2;
        }
    }
    return tempo;
  }
}
