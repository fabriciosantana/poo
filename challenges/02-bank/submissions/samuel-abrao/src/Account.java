public class Account{
    public static void main(String[] args){
        private int id;
        private double balance;
        private int accountCounter = 1000;

        public Account(){
            accountCounter++;
            this.id = accountCounter;
            this.balance = 0.0;
        }

        public int getId(){
            return id;
        }
        
        public String getFormatedBalance(){
            return String.format("R$: %.2f", balance);
        }

        public double getBalance(){
            return balance;
        }

        public void setBalance(double balance){
            if(balance >= 0){
                this.balance = balance;
            }else{
                System.out.println("Saldo não pode ser negativo.");
            }
        }

        public void deposit(double amount) {
            if(amount > 0) {
                balance += amount;
            }else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public boolean withdraw(double amount){
            if(amount  > 0 && balance >= amount){
                balance -= amount;
                return true;
            }else{
                System.out.println("Valor de saque inválido ou saldo insuficiente.");
                return false;
            }
        }
    }
}