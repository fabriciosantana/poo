import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderSample {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.print("Digite seu nome: ");
        String nome = reader.readLine();

        System.out.print("Digite sua idade: ");
        int idade = Integer.parseInt(reader.readLine());

        System.out.print("Digite sua altura: ");
        double altura = Double.parseDouble(reader.readLine());

        System.out.printf("Olá %s, você tem %d anos e %.2f m de altura.%n", nome, idade, altura);

        int i = reader.read();
        System.out.printf("Resultado do read: %d%n", i);
    }
}