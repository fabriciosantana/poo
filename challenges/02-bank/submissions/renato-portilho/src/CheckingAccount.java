public class CheckingAccount extends Account {
 private static double maintenanceFee = 10.0;
    
 @Override
    public void setBalance(double balance) {
        if (balance >= -500) {
            this.setBalance(balance);
        } else {
            System.out.println("O saldo insuficiente e sem limite de crédito");
        }

    }


    public void applyMaitenanceFee(double maintenanceFee){
            setBalance(getBalance() - maintenanceFee);
    }

    
}
