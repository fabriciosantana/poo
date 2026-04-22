import java.util.Scanner;
//02-01

public class HeartRates{
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }
    
    public String getFirstName() {return firstName; }
    public String getLastName() {return lastName; }
    public int getDayOfBirth() {return dayOfBirth; }
    public int getMonthOfBirth() {return monthOfBirth; }
    public int getYearOfBirth() {return yearOfBirth; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge(int currentYear){
        int Idade = currentYear -  yearOfBirth;
        return Idade;
    }

    public int calculateMaxHeartRate(int Idade){
        int MaxRate = 220 - Idade; 
        return MaxRate;
    }

    public void calculateTargetHeartRate(int MaxRate){
        double MaxFrequence = MaxRate * 0.85;
        double MinFrequence = MaxRate * 0.50;
        System.out.print("Faixa de frequência cardíaca alvo: " + MinFrequence + " bpm - " + MaxFrequence + " bpm");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int currentYear = 2024;

        //Inserção de Dados do Individuo
        System.out.print("Digite seu Primeiro Nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Digite seu Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("Digite sua data de Nascimento (dia, mês e ano separados por espaço):  ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        HeartRates pessoa = new HeartRates (firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        int Idade = pessoa.calculateAge(currentYear);
        int MaxRate = pessoa.calculateMaxHeartRate(Idade);

        //Empressão do Relatório Final
        System.out.println("------ Relatório de Saúde ------");
        System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de Nascimento: %d/%d/%d", 
        pessoa.getDayOfBirth(), 
        pessoa.getMonthOfBirth(), 
        pessoa.getYearOfBirth());

        System.out.println("Idade: " + Idade /* pessoa.calculateAge(currentYear)*/ + " anos");
        System.out.println("Frequência cardíaca máxima: " + MaxRate /*pessoa.calculateMaxHeartRate(Idade) */);
        pessoa.calculateTargetHeartRate(MaxRate);
    }

}