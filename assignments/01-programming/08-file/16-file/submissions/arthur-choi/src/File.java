import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static void main(String[] args){
        String inputPath = (args.length >= 1) ? args[0] : "compras.txt";
        String outputPath = (args.length >= 2) ? args[1] : "report.txt";

        Path caminhoEntrada = Paths.get(inputPath);
        Path caminhoSaida = Paths.get(outputPath);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            //erro caso o arquivo de entrada não exista
            if(!Files.exists(caminhoEntrada)){
                System.out.println("Input file does not exist: " + inputPath);
                return;
            }

            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for(String linha : linhas){
                String[] partes = linha.split(",");
                if(partes.length < 3){continue;}
                String nomeCliente = partes[0].trim();
                String valorString = partes[2].trim();
                try {
                    double valorCompra = Double.parseDouble(valorString);

                    int index = clientes.indexOf(nomeCliente);
                    if(index != -1){
                        double valorAtual = totais.get(index);
                        totais.set(index,valorAtual + valorCompra);
                    } else {
                        clientes.add(nomeCliente);
                        totais.add(valorCompra);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + linha); 
                } 
            }

            ArrayList<String> outputLines = new ArrayList<>();
            for(int i = 0; i < clientes.size(); i++){
                outputLines.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(caminhoSaida, outputLines);
            System.out.println("Relatório criado em: " + caminhoSaida.toAbsolutePath());
            
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        

    }
}
