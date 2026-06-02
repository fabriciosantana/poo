import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {

        try  { 
            printAccounts();

            openNewAccounts();
        } 
        catch (IOException e) {//(SecurityException |  | FormatterClosedException e) { 
            System.out.println(e);
        } 
    }

    private static void printAccounts() throws  IOException{
       
        Path path = Path.of("data/clients.txt");
        List<String> accounts = Files.readAllLines(path);

        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance"); 

        for (String account : accounts){
            String[] accountData = account.split(" ");

            int accountNumber = Integer.parseInt(accountData[0]); 
            String firstName = accountData[1]; 
            String lastName = accountData[2]; 
            double balance = Double.parseDouble(accountData[3]); 

            System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber, firstName, lastName, balance);
            
        }
   } 

   private static void openNewAccounts() throws IOException{

        Path path = Path.of("data/clients.txt");
        List<String> newAccounts = new ArrayList<>();
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("%s%n%s%n? ",
        "Insira o número da conta, nome, sobrenome e saldo.",
                "Enter end-of-file indicator to end input."); 
            
            while (input.hasNext()) {
                try { 
                    String account = String.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
                    //Files.write(path, account.getBytes(), StandardOpenOption.APPEND);
                    newAccounts.add(account);
                } 
                catch (IllegalFormatException e) { 
                    System.err.println("Entrada inválida."); 
                    input.nextLine(); // discard input so user can try again 
                } 
                System.out.print("? "); 
            }

            Files.write(path, newAccounts, StandardOpenOption.APPEND);
            System.out.printf("%nTotal de contas: %d%n", Files.readAllLines(path).size());
            System.out.printf("%nTamanho do arquivo: %d%n", Files.size(path));
        } 
   }
}
