import java.util.Scanner;
import java.time.Year;

class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        input.close();

        //---- Criar um objeto HeartRates ----//
        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        //---- Pega o ano atual para usar no cálculo da idade ----//
        int currentYear = Year.now().getValue();

        //---- Exibir as informações do usuário e os cálculos ----//
        System.out.printf("Nome: %s %s%n", pessoa.getFirstName(), pessoa.getLastName());
        System.out.printf("Data de nascimento: %d/%d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        
        //----  Calcular e exibir a idade, a frequência cardíaca máxima e a faixa alvo ----//
        System.out.printf("Idade: %d anos%n", pessoa.calculateAge(currentYear));
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", pessoa.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", pessoa.calculateTargetHeartRate());
    }
} 


// ---- Classe HeartRates ----//
public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // ---- Construtor ---- //
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // ---- Métodos de Acesso (Get e Set) ---- //
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    // ---- Métodos Públicos de Cálculo  ---- //

    // Este é agora o ÚNICO método que calcula a idade.
    public int calculateAge(int currentYear) {
        return currentYear - this.yearOfBirth;
    }
    
    // MUDANÇA 1: O método getAgeNow() foi REMOVIDO.

    // MUDANÇA 2: Este método agora usa o calculateAge(currentYear)
    public int calculateMaxHeartRate() {
        int currentYear = Year.now().getValue();
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        
        int lowerBound = (int) (maxRate * 0.50);
        int upperBound = (int) (maxRate * 0.85);
        
        return String.format("%d bpm - %d bpm", lowerBound, upperBound);
    }
}