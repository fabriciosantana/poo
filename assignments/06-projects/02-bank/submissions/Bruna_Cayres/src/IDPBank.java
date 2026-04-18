import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer currentCustomer = null;
        Account currentAccount = null;

        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair\n");
            System.out.print("Digite o número correspondente à opção desejada: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine().trim();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine().trim();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine().trim();

                    currentCustomer = createCustomer(firstName, lastName, cpf);
                    currentAccount = openAccount(currentCustomer);
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    System.out.println(currentCustomer.displayInformation());
                    System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case "2":
                    if (currentCustomer == null) {
                        System.out.println("Nenhum cliente cadastrado.\n");
                        break;
                    }
                    System.out.println();
                    System.out.println(currentCustomer.displayInformation());
                    System.out.println("Pressione enter para continuar...");
                    scanner.nextLine();
                    break;
                case "3":
                    if (currentAccount == null) {
                        System.out.println("Nenhuma conta disponível. Abra uma conta primeiro.\n");
                        break;
                    }
                    System.out.println("\nDigite o valor que deseja depositar.");
                    System.out.print("Valor: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine().trim());
                        deposit(currentAccount, amount);
                        System.out.println("Valor depositado com sucesso na conta do cliente " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
                        System.out.println(currentCustomer.displayInformation());
                        System.out.println("Pressione enter para continuar...");
                        scanner.nextLine();
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Digite um número válido.\n");
                    }
                    break;
                case "4":
                    if (currentAccount == null) {
                        System.out.println("Nenhuma conta disponível. Abra uma conta primeiro.\n");
                        break;
                    }
                    System.out.println("\nDigite o valor que deseja sacar.");
                    System.out.print("Valor: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine().trim());
                        boolean ok = withdraw(currentAccount, amount);
                        if (ok) {
                            System.out.println("Valor sacado com sucesso da conta do cliente " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
                        } else {
                            System.out.println("Não foi possível sacar valor. Verifique o saldo ou o valor informado.\n");
                        }
                        System.out.println(currentCustomer.displayInformation());
                        System.out.println("Pressione enter para continuar...");
                        scanner.nextLine();
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Digite um número válido.\n");
                    }
                    break;
                case "5":
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account acc = new Account();
        customer.addAccount(acc);
        return acc;
    }

    public static boolean deposit(Account account, double amount) {
        return account.deposit(amount);
    }

    public static boolean withdraw(Account account, double amount) {
        return account.withdraw(amount);
    }
}
