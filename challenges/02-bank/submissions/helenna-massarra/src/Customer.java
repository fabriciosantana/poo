
import java.util.ArrayList;

    class Customer {
        private String firstName;
        private String lastName;
        private String cpf;
        private ArrayList<Account> accounts;

        public Customer(String firstName, String lastName, String cpf) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.cpf = cpf;
            this.accounts = new ArrayList<>();
        }

        public void addAccount(Account account) {
            accounts.add(account);
        }

        public ArrayList<Account> getAccounts() {
            return accounts;
        }

        public String getCPF(){
            return cpf;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public String displayInformation() {
            StringBuilder info = new StringBuilder("\nNome: " + firstName + " " + lastName + "\n" + "CPF: " + cpf + "\n");

            if(accounts.isEmpty()) {
                info.append("Nenhuma conta cadastrada.\n");
            } else {
                for (Account acc : accounts) {
                    info.append("\nTipo: ").append(acc.getType())
                    .append("\n").append(acc.toString()).append("\n");  
                }
            }

            return info.toString();
        }

        public Account getAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getId() == id) {
                return acc;
            }
        }
        return null;
    }
    }