import java.util.Scanner;

public class HeartRates {

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    
    public int getDayOfBirth(){
        return dayOfBirth;
    }

    public int getMonthOfBirth(){
        return monthOfBirth;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDay(int dayOfBirth) {
       if(dayOfBirth > 0) {
            this.dayOfBirth = dayOfBirth;
       } else {
        System.out.println("Dia Inválido!");
       }

    }

    public void setMonth(int monthOfBirth) {
       if(monthOfBirth > 0) {
            this.monthOfBirth = monthOfBirth;
       } else {
        System.out.println("Mês Inválido!");
       }
    
    }

    public void setYear(int yearOfBirth) {
       if(yearOfBirth > 0) {
            this.yearOfBirth = yearOfBirth;
       } else {
        System.out.println("Ano Inválido!");
       }
       
    }

    public int calculateAge(int currentYear){
        int idade = currentYear - this.yearOfBirth;
        return idade;
    }

    public int calculateMaxHeartRate(){
        int FCmax = 220 - calculateAge(2026);

        return FCmax;
    }

    public String calculateTargetHeartRate(){
        int max = (int) (calculateMaxHeartRate() * 0.85);
        int min = (int) (calculateMaxHeartRate() * 0.5);

        return min + " bpm - " + max + " bpm";
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        String nome = ler.nextLine();
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = ler.nextLine();
        System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = ler.nextInt();
        int mes = ler.nextInt();
        int ano = ler.nextInt();

        HeartRates alguem = new HeartRates(nome, sobrenome, dia, mes, ano);
        
        System.out.println("Nome: " + alguem.getFirstName() + " " + alguem.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n",
            alguem.getDayOfBirth(),
            alguem.getMonthOfBirth(),
            alguem.getYearOfBirth());
        System.out.println("Idade: " + alguem.calculateAge(2026) + " anos");
        System.out.println("Frequência cardíaca máxima:a " + alguem.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + alguem.calculateTargetHeartRate());

    }  
}
    

