import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo: ");
        String p = scanner.nextLine();
        Path caminho = Path.of(p);
        try {
            Files.write(caminho, Arrays.asList("nomeCliente, nomeProduto, valor"));
            while (true) { 
                System.out.print("Registre mais um Cliente ou digite sair: \n");
                String cliente = scanner.nextLine();
               
                if(cliente.equalsIgnoreCase("sair")){
                    break;
                }

                System.out.print("\nDigite o Produto: ");
                String produto = scanner.nextLine();
                
                System.out.print("\nDigite o valor: ");
                String valor = scanner.nextLine();

                String saida = cliente + ", " + produto + ", " + valor + " ";
                Files.write(caminho ,Arrays.asList(saida), StandardOpenOption.APPEND);

                System.out.print("\nRegistro Realizado com Sucesso!");
            }

            System.out.print("\nArquivo Salvo!");

        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }

    private static void mostrarArquivo(Path caminho) {
        try {
            List<String> linhas = Files.readAllLines(caminho);
            for (String linha : linhas){
                System.out.print(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}