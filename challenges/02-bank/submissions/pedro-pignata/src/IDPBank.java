import java.util.Scanner;

public class IDPBank {
    private static Customer customer = null;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
            Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:

            1. Abrir conta
            2. Consultar cliente 
            3. Depositar
            4. Sacar
            5. Transferir
            6. Processamento mensal
            7. Sair
            Digite o número correspondente à opção desejada: 
            """);

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1 -> createCustomer();

                case 2 -> consultarCliente();                

                case 3 -> depositar();                

                case 4 -> withdraw();                

                case 5 -> transferir();

                case 6 -> executarProcessamentoMensal();

                case 7 ->{ 
                System.out.println("Obrigado por usar o IDP Bank.");
                return; 
                }

                default ->{
                System.out.println(""
                +"Opção inválida. Tente novamente.\n"
                +"Digite o número correspondente à opção desejada: ");
                }
            }
        }
    }

    public static Customer createCustomer(){
        Scanner scanner = new Scanner(System.in);
        if (customer == null) {
            System.out.println("Digite os dados para a abertura do cliente.\n");
            
            System.out.print("Primeiro nome: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Sobrenome: ");
            String lastName = scanner.nextLine();
            
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            customer = new Customer(firstName, lastName, cpf);
        }

        System.out.println("Qual tipo de conta deseja abrir?");
        System.out.println("1. Conta Corrente\n2. Conta Poupança\n3. Conta Salário");
        int tipoConta = scanner.nextInt();

        Account novaConta = null;
        switch (tipoConta) {
            case 1 -> novaConta = new CheckingAccount(0.0);
            case 2 -> novaConta = new SavingsAccount(0.0);
            case 3 -> novaConta = new SalaryAccount(0.0);
            default -> {
                System.out.println("Tipo inválido.");
                return null;
            }
        }

        if (customer.addAccount(novaConta)) {
            System.out.println("Conta criada com sucesso!");
            System.out.println(customer.displayAccounts());
        } else {
            System.out.println("O cliente já possui esse tipo de conta.");
        }
        return customer;
    }       
    

    public static void consultarCliente() {
        if (customer == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println(customer.displayInformation());
    }

    public static void depositar() {
        if (customer == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a conta para depositar:");
        System.out.println(customer.displayAccounts());
        int opcao = scanner.nextInt();

        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();

        Account conta = getContaPorOpcao(opcao);
        if (conta instanceof SalaryAccount) {
            System.out.println("Depósitos manuais não permitidos em Conta Salário.");
            return;
        }

        conta.deposit(valor);
        System.out.println("Depósito realizado. Novo saldo: R$ " + conta.getBalance());
    }

        public static void withdraw() {
            if (customer == null) {
                System.out.println("Nenhum cliente cadastrado.");
                return;
            }
    
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha a conta para sacar:");
            System.out.println(customer.displayAccounts());
            int opcao = scanner.nextInt();
    
            System.out.print("Valor do saque: ");
            double valor = scanner.nextDouble();
    
            Account conta = getContaPorOpcao(opcao);
            try {
                if (conta.withdraw(valor)) {
                    System.out.println("Saque realizado. Novo saldo: R$ " + conta.getBalance());
                } else {
                    System.out.println("Saque não permitido.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void transferir() {
            if (customer == null || customer.getSalaryAccount() == null) {
                System.out.println("Cliente ou Conta Salário inexistente.");
                return;
            }
    
            Scanner scanner = new Scanner(System.in);
            System.out.println("Transferir da Conta Salário para:");
            System.out.println("1. Conta Corrente\n2. Conta Poupança");
            int destino = scanner.nextInt();
    
            System.out.print("Valor da transferência: ");
            double valor = scanner.nextDouble();
    
            SalaryAccount origem = customer.getSalaryAccount();
            Account destinoConta = (destino == 1) ? customer.getCheckingAccount() : customer.getSavingsAccount();
    
            if (destinoConta == null) {
                System.out.println("Conta de destino inexistente.");
                return;
            }
    
            try {
                if (origem.withdraw(valor)) {
                    destinoConta.deposit(valor);
                    System.out.println("Transferência realizada com sucesso.");
                } else {
                    System.out.println("Transferência não realizada.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void executarProcessamentoMensal() {
            if (customer == null) return;
    
            if (customer.getCheckingAccount() != null) {
                customer.getCheckingAccount().applyMaintenanceFee();
                System.out.println("Taxa mensal aplicada à Conta Corrente.");
            }
    
            if (customer.getSavingsAccount() != null) {
                customer.getSavingsAccount().applyInterest();
                System.out.println("Rendimento aplicado à Conta Poupança.");
            }
        }
    
        private static Account getContaPorOpcao(int opcao) {
            return switch (opcao) {
                case 1 -> customer.getCheckingAccount();
                case 2 -> customer.getSavingsAccount();
                case 3 -> customer.getSalaryAccount();
                default -> null;
            };
        }

}