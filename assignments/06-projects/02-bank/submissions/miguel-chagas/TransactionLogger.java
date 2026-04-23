import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogger {
    public static void logTransaction(String cpf, String operation, double amount, double finalBalance) {
        String filename = "transacoes_" + cpf.replaceAll("[^0-9]", "") + ".txt";
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            bw.write("[" + timestamp + "] " + operation + ": R$" + String.format("%.2f", amount) + " | SALDO FINAL: R$" + String.format("%.2f", finalBalance));
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao gravar log de transação: " + e.getMessage());
        }
    }

    public static void displayTransactions(String cpf) {
        String filename = "transacoes_" + cpf.replaceAll("[^0-9]", "") + ".txt";
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Ainda não houve movimentações na conta.");
            return;
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println("Extrato da conta (CPF: " + cpf + "):");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler log de transação: " + e.getMessage());
        }
    }
}
