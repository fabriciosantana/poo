import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main{

    public static void main(String[] args){

        Path file = Path.of(args[0]);
        Path report = Path.of(args[1]);
        
        List<String> compras = new ArrayList<>();
        
        try{
            compras = Files.readAllLines(file);
        } catch(IOException ioe){
            System.out.print("Arquivo não encontrado");
        }
        
        List<String> nome = new ArrayList<>();
        List<Double> valor = new ArrayList<>();

        for(String compra : compras){
            String[] campo = compra.split(",");
            if(campo.length < 3) continue;

            try{
                double valueToInsert = Double.parseDouble(campo[2]);

                if(!nome.contains(campo[0])){
                    nome.add(campo[0]);
                    valor.add(valueToInsert);
                } else{
                    int idx = nome.indexOf(campo[0]);
                    double valorAtual = valor.get(idx);
                    double somaValores = valorAtual + valueToInsert;
                    valor.set(idx, somaValores);
                }

            } catch(NumberFormatException e){
                continue;
            }
        }

        List<String> clienteTotalCompra = new ArrayList<>();
        
        for(int i = 0; i < nome.size(); i++){
           clienteTotalCompra.add(nome.get(i) +": " + valor.get(i));
        }

        try{
            Files.write(report, clienteTotalCompra);
        } catch(IOException ioe){
            System.out.print("Arquivo não encontrado");
        }
    }
}