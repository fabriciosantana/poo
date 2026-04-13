import java.util.Scanner;

public class IDPBank {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static Customer currentCustomer;

	public static void main(String[] args) {
		boolean running = true;

		while (running) {
			showMenu();
			String option = SCANNER.nextLine();

			switch (option) {
				case "1":
					handleOpenAccount();
					break;
				case "2":
					handleConsultCustomer();
					break;
				case "3":
					handleDeposit();
					break;
				case "4":
					handleWithdraw();
					break;
				case "5":
					running = false;
					break;
				default:
					System.out.println("\nOpção inválida. Tente novamente.\n");
			}
		}
	}

	public static Customer createCustomer(String firstName, String lastName, String cpf) {
		return new Customer(firstName, lastName, cpf);
	}

	public static Account openAccount(Customer customer) {
		Account account = new Account();
		customer.addAccount(account);
		return account;
	}

	public static boolean deposit(double amount) {
		if (!hasCustomerAccount()) {
			return false;
		}
		return currentCustomer.getAccounts().deposit(amount);
	}

	public static boolean withdraw(double amount) {
		if (!hasCustomerAccount()) {
			return false;
		}
		return currentCustomer.getAccounts().withdraw(amount);
	}

	private static void showMenu() {
		System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n");
		System.out.println("1. Abrir conta");
		System.out.println("2. Consultar cliente");
		System.out.println("3. Depositar");
		System.out.println("4. Sacar");
		System.out.println("5. Sair\n");
		System.out.print("Digite o número correspondente à opção desejada: ");
	}

	private static void handleOpenAccount() {
		System.out.println("\nDigite os dados para a abertura da conta.\n");
		System.out.print("Primeiro nome: ");
		String firstName = SCANNER.nextLine();
		System.out.print("Sobrenome: ");
		String lastName = SCANNER.nextLine();
		System.out.print("CPF: ");
		String cpf = SCANNER.nextLine();

		currentCustomer = createCustomer(firstName, lastName, cpf);
		openAccount(currentCustomer);

		System.out.println("\nCliente cadastrado com sucesso!\n");
		System.out.println(currentCustomer.displayInformation());
		waitEnter();
	}

	private static void handleConsultCustomer() {
		if (!hasCustomerAccount()) {
			System.out.println("\nNenhum cliente cadastrado.\n");
			waitEnter();
			return;
		}

		System.out.println();
		System.out.println(currentCustomer.displayInformation());
		waitEnter();
	}

	private static void handleDeposit() {
		if (!hasCustomerAccount()) {
			System.out.println("\nNenhum cliente cadastrado.\n");
			waitEnter();
			return;
		}

		System.out.println("\nDigite o valor que deseja depositar.\n");
		System.out.print("Valor: ");
		double amount = readDouble();

		boolean deposited = deposit(amount);
		if (deposited) {
			System.out.println("\nValor depositado com sucesso na conta do cliente "
				+ currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
			System.out.println(currentCustomer.displayInformation());
		} else {
			System.out.println("\nNão foi possível realizar o depósito.\n");
		}
		waitEnter();
	}

	private static void handleWithdraw() {
		if (!hasCustomerAccount()) {
			System.out.println("\nNenhum cliente cadastrado.\n");
			waitEnter();
			return;
		}

		System.out.println("\nDigite o valor que deseja sacar.\n");
		System.out.print("Valor: ");
		double amount = readDouble();

		boolean withdrew = withdraw(amount);
		if (withdrew) {
			System.out.println("\nValor sacado com sucesso da conta do cliente "
				+ currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
			System.out.println(currentCustomer.displayInformation());
		} else {
			System.out.println("\nNão foi possível realizar o saque. Verifique valor e saldo.\n");
		}
		waitEnter();
	}

	private static boolean hasCustomerAccount() {
		return currentCustomer != null && currentCustomer.getAccounts() != null;
	}

	private static double readDouble() {
		String input = SCANNER.nextLine().replace(",", ".").trim();
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException exception) {
			return -1.0;
		}
	}

	private static void waitEnter() {
		System.out.print("\nPressione Enter para continuar...");
		SCANNER.nextLine();
		System.out.println();
	}
}
