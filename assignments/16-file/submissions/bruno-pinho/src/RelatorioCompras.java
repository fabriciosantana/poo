import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Erro: São necessários dois argumentos.");
            System.err.println("Uso: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            System.exit(1); 
        }

        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];

        
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        // 3. Processar o arquivo de entrada
        processarArquivoEntrada(caminhoEntrada, clientes, totais);

        // 4. Gerar e escrever o arquivo de saída
        gerarArquivoSaida(caminhoSaida, clientes, totais);

        System.out.println("Relatório gerado com sucesso em: " + caminhoSaida);
    }

    /**
     * Lê o arquivo de entrada, processa as linhas e preenche as listas.
     */
    private static void processarArquivoEntrada(String caminho, ArrayList<String> clientes, ArrayList<Double> totais) {
        
        // Converte a string do caminho para um objeto Path (NIO.2)
        Path pathEntrada = Paths.get(caminho);
        List<String> linhas;

        // 5. Leitura do arquivo (Requisito: Files)
        try {
            // Files.readAllLines lê todas as linhas do arquivo de uma vez
            linhas = Files.readAllLines(pathEntrada);
        } catch (IOException e) {
            System.err.println("Erro fatal ao ler o arquivo de entrada: " + e.getMessage());
            // Se não conseguirmos ler o arquivo, não há como continuar.
            System.exit(1);
            return; // Necessário para o compilador (apesar do System.exit)
        }

        // 6. Processamento de cada linha
        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue; // Ignora linhas em branco
            }

            String[] campos = linha.split(",");

            // 7. Validação de formato (Requisito: ignorar malformadas)
            if (campos.length < 3) {
                System.out.println("Ignorando linha malformada: " + linha);
                continue; // Pula para a próxima linha
            }

            try {
                String nomeCliente = campos[0].trim();
                // O campo 1 (produto) não é usado no relatório
                
                // 8. Tratamento de exceção numérica (Requisito)
                double valor = Double.parseDouble(campos[2].trim());

                // 9. Lógica de acumulação com listas paralelas (Requisito)
                
                // Verifica se o cliente já existe na lista 'clientes'
                int indiceCliente = clientes.indexOf(nomeCliente);

                if (indiceCliente != -1) {
                    // Cliente já existe.
                    // Pegamos o total atual no mesmo índice da lista 'totais'
                    double totalAtual = totais.get(indiceCliente);
                    // Atualizamos o total somando o novo valor
                    totais.set(indiceCliente, totalAtual + valor);
                } else {
                    // Cliente é novo.
                    // Adicionamos o nome na lista 'clientes'
                    clientes.add(nomeCliente);
                    // Adicionamos o valor na lista 'totais' (na mesma posição)
                    totais.add(valor);
                }

            } catch (NumberFormatException e) {
                System.err.println("Ignorando linha com valor numérico inválido: " + linha);
            }
        }
    }

    /**
     * Gera as linhas do relatório e escreve no arquivo de saída.
     */
    private static void gerarArquivoSaida(String caminho, ArrayList<String> clientes, ArrayList<Double> totais) {
        
        // 10. Preparar conteúdo para gravação
        ArrayList<String> linhasSaida = new ArrayList<>();

        // Itera pelas listas. Como são paralelas, o tamanho é o mesmo.
        for (int i = 0; i < clientes.size(); i++) {
            String cliente = clientes.get(i);
            Double total = totais.get(i);

            // Formata a linha de saída conforme o exemplo "João: 150.0"
            String linhaRelatorio = cliente + ": " + total;
            linhasSaida.add(linhaRelatorio);
        }

        // 11. Escrita no arquivo (Requisito: Path e Files)
        Path pathSaida = Paths.get(caminho);

        try {
            // Files.write grava uma coleção de strings no arquivo,
            // criando o arquivo se não existir e sobrescrevendo se existir.
            Files.write(pathSaida, linhasSaida);
        } catch (IOException e) {
            System.err.println("Erro fatal ao gravar o arquivo de saída: " + e.getMessage());
            System.exit(1);
        }
    }
}