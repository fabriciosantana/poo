import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileApp{

    public static List<String> readFile(Path caminho){
        
    
        if (Files.exists(caminho)) {
            System.out.println("Nome: " + caminho.getFileName());
            
            try {
               
                List<String> linhas = Files.readAllLines(caminho);
                return linhas;
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                return List.of();
            }

        } else {
            System.out.println("Arquivo não encontrado no caminho: " + caminho.toAbsolutePath());
            return List.of();
            
        }
    }

    public static void showList(List<String> linhas){

            System.out.println("--- Conteúdo do Arquivo ---");
                for (String linha : linhas) {
                    System.out.println(linha);
                }
    }

    public static void GravarRelatorio(List<String> lista, Path novocaminho){

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

            for(String linha : lista){
                String[] colunas = linha.split(",");
                    if(colunas.length >=3){
                        String nome = colunas[0];
                        try{
                            Double valor = Double.parseDouble(colunas[2]);

                            if (nomesClientes.contains(nome)){
                                int indice = nomesClientes.indexOf(nome);
                                double valorAntigo = totaisCompras.get(indice);
                                totaisCompras.set(indice,valorAntigo + valor);
                            }else{

                                nomesClientes.add(nome);
                                totaisCompras.add(valor);
                            }

                        }catch(NumberFormatException e){
                            System.err.println("Aviso: Linha ignorada por conter valor numérico inválido -> [ " + linha + " ]");
                        }
                    }

            }
        System.out.println("--- Valores Totais ---");
        for (int i = 0; i < nomesClientes.size(); i++) {
            System.out.printf("Nome: %s | Total Acumulado: R$ %.2f%n", nomesClientes.get(i), totaisCompras.get(i));
        }

        // ESCRITA DO ARQUIVO:
        // Criando a lista de linhas de texto para salvar
        List<String> linhasParaGravar = new ArrayList<>();
        for (int i = 0; i < nomesClientes.size(); i++) {
            // O exemplo de saída do enunciado pede "Nome: Valor" (ex: João: 150.0)
            String linhaTexto = String.format("%s: %.1f", nomesClientes.get(i), totaisCompras.get(i));
            linhasParaGravar.add(linhaTexto);
        }

        // Salva no arquivo
        try {
            if (!Files.exists(novocaminho)) {
                Files.createFile(novocaminho);
            }
            Files.write(novocaminho, linhasParaGravar);
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }



        
    
    public static void main(String[] args){
        
        Path novocaminho = Paths.get("/workspaces/poo-3-semestre/assignments/01-programming/08-file/16-file/submissions/renan-figueiroa/report.txt");

        Path caminho = Path.of("/workspaces/poo-3-semestre/assignments/01-programming/08-file/16-file/data/compras.txt");
        

        List<String> lista = readFile(caminho);
        showList(lista);
        
        GravarRelatorio(lista, novocaminho);
    }      
}
