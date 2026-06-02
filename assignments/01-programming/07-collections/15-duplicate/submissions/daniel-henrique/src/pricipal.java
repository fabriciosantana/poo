import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CadastroNomes cadastro = new CadastroNomes();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        String nome;

        do {
            System.out.print("> ");
            nome = scanner.nextLine();

            if (!nome.equalsIgnoreCase("fim")) {
                cadastro.adicionarNome(nome);
            }

        } while (!nome.equalsIgnoreCase("fim"));

        System.out.println("\nNomes cadastrados:");
        System.out.println(cadastro.getNomes());

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        String busca;

        do {
            System.out.print("> ");
            busca = scanner.nextLine();

            if (!busca.equalsIgnoreCase("sair")) {

                if (cadastro.pesquisarNome(busca)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }

        } while (!busca.equalsIgnoreCase("sair"));

        scanner.close();
    }
}