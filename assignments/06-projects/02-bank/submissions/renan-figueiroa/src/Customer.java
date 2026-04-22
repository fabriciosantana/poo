public class Customer{

        private String firstName;
        private String lastName;
        private String cpf;
        private Account accounts;

        public Customer(String firstName,String lastName,String cpf){
            this.firstName = firstName;
            this.lastName = lastName;
            this.cpf = cpf;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getLastName(){
            return lastName;
        }

        public String getCpf(){
            return cpf;
        }
        public boolean addAccount(){

        }
}