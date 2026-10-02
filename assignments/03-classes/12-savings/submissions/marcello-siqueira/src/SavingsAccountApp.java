import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {

    private static final String NEGATIVE_BALANCE_MESSAGE = "O saldo inicial não pode ser negativo.";
    private static final String NEGATIVE_RATE_MESSAGE = "A taxa de juros não pode ser negativa.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        // o % digitado junto da taxa (ex.: 5%) vira separador e e descartado
        scanner.useDelimiter("[\\s%]+");

        runSimulation(scanner);

        scanner.close();
    }

    private static void runSimulation(Scanner scanner) {
        double initialBalance = readNonNegative(scanner, "Informe o saldo inicial: ", NEGATIVE_BALANCE_MESSAGE);
        if (initialBalance < 0) {
            return;
        }
        double annualRate = readNonNegative(scanner, "Informe a taxa de juros anual (%): ", NEGATIVE_RATE_MESSAGE);
        if (annualRate < 0) {
            return;
        }

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate);

        System.out.printf(Locale.US, "Saldos com taxa de juros de %.1f%%:%n", SavingsAccount.getAnnualInterestRate());
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            printBalance(month, account);
        }

        double newRate = readNonNegative(scanner, "Informe a nova taxa de juros anual: ", NEGATIVE_RATE_MESSAGE);
        if (newRate < 0) {
            return;
        }

        System.out.println("Alterando taxa de juros anual para " + formatRate(newRate) + "%...");
        System.out.println();
        SavingsAccount.setAnnualInterestRate(newRate);
        account.calculateMonthlyInterest();
        printBalance(13, account);
    }

    // devolve -1 quando a entrada termina antes de chegar um valor valido
    private static double readNonNegative(Scanner scanner, String prompt, String negativeMessage) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                System.out.println();
                return -1;
            }
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido. Digite um número.");
                scanner.next();
            } else {
                double value = scanner.nextDouble();
                if (value >= 0) {
                    return value;
                }
                System.out.println(negativeMessage);
            }
        }
    }

    private static void printBalance(int month, SavingsAccount account) {
        System.out.printf(Locale.US, "Mês %d: R$%.2f%n", month, account.getSavingsBalance());
    }

    // 5 aparece como "5" e 5.5 continua "5.5", como no exemplo do README
    private static String formatRate(double rate) {
        if (rate == Math.floor(rate)) {
            return String.format(Locale.US, "%.0f", rate);
        }
        return String.valueOf(rate);
    }
}
