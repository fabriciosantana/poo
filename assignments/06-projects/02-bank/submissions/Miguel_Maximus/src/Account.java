public class Account {
	private static int accountCounter = 1000;

	private int id;
	private double balance;

	public Account() {
		accountCounter++;
		this.id = accountCounter;
		this.balance = 0.0;
	}

	public static int getAccountCounter() {
		return accountCounter;
	}

	public static void setAccountCounter(int accountCounter) {
		Account.accountCounter = accountCounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBalance() {
		return String.format("R$ %.2f", balance);
	}

	public double getBalanceValue() {
		return balance;
	}

	public boolean setBalance(double balance) {
		if (balance < 0) {
			return false;
		}
		this.balance = balance;
		return true;
	}

	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		}
		this.balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		if (amount <= 0) {
			return false;
		}
		if (this.balance - amount < 0) {
			return false;
		}
		this.balance -= amount;
		return true;
	}
}
