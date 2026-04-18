public class IDPBank {
    public static void main(String[] args) {
        // Lógica do menu principal e fluxo do programa
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account account = new Account();
        customer.addAccount(account);
        return account;
    }

    public static void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public static void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }
}
