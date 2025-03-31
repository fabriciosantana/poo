import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;

        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    if (customer == null) {
                        System.out.println("\nDigite os dados para a abertura da conta.");
                        System.out.print("Primeiro nome: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Sobrenome: ");
                        String lastName = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        customer = new Customer(firstName, lastName, cpf);
                    }

                    System.out.println("\nQual tipo de conta deseja abrir?");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    System.out.println("3. Conta Salário");
                    System.out.print("Digite o número da opção desejada: ");

                    int accountType = scanner.nextInt();
                    scanner.nextLine();

                    Account newAccount = null;
                    switch (accountType) {
                        case 1:
                            newAccount = new CheckingAccount();
                            break;
                        case 2:
                            newAccount = new SavingsAccount();
                            break;
                        case 3:
                            newAccount = new SalaryAccount();
                            break;
                        default:
                            System.out.println("Tipo de conta inválido.");
                            break;
                    }

                    if (newAccount != null) {
                        customer.addAccount(newAccount);
                        System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    if (customer != null) {
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (customer != null) {
                        System.out.print("Digite o número da conta (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int accountTypeDeposit = scanner.nextInt();
                        scanner.nextLine();

                        Account account = customer.getAccount(accountTypeDeposit);
                        if (account != null) {
                            System.out.print("Digite o valor que deseja depositar: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            account.deposit(amount);
                            System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFullName() + ".");
                            System.out.println(customer.displayInformation());
                        } else {
                            System.out.println("Conta inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    if (customer != null) {
                        System.out.print("Digite o número da conta (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int accountTypeWithdraw = scanner.nextInt();
                        scanner.nextLine();

                        Account account = customer.getAccount(accountTypeWithdraw);
                        if (account != null) {
                            System.out.print("Digite o valor que deseja sacar: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (account.withdraw(amount)) {
                                System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFullName() + ".");
                                System.out.println(customer.displayInformation());
                            } else {
                                System.out.println("Saldo insuficiente ou valor inválido.");
                            }
                        } else {
                            System.out.println("Conta inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    if (customer != null) {
                        System.out.print("Digite o número da conta de origem (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int fromAccountType = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o número da conta de destino (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int toAccountType = scanner.nextInt();
                        scanner.nextLine();

                        Account fromAccount = customer.getAccount(fromAccountType);
                        Account toAccount = customer.getAccount(toAccountType);

                        if (fromAccount != null && toAccount != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (fromAccount.withdraw(amount)) {
                                toAccount.deposit(amount);
                                System.out.println("\nTransferência realizada com sucesso.");
                                System.out.println(customer.displayInformation());
                            } else {
                                System.out.println("Saldo insuficiente ou valor inválido.");
                            }
                        } else {
                            System.out.println("Conta de origem ou destino inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("Obrigado por usar o IDP Bank. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}