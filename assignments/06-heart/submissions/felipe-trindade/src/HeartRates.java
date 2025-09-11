import java.util.Scanner;
import java.time.LocalDate;

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

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge(int currentYear){
        int age = currentYear - yearOfBirth;
        if (currentYear == LocalDate.now().getYear()){
            LocalDate today = LocalDate.now();
            LocalDate birthdayThisYear = LocalDate.of(currentYear, monthOfBirth, dayOfBirth);
            if (today.isBefore(birthdayThisYear)){
                age--;
            }
        }
        return age;
    }

    public int calculateMaxHeartRate(){
        int age2025 = calculateAge(2025);
        return 220 - age2025;
    }

    public String calculateTargetHeartRate(){
        int max = calculateMaxHeartRate();
        int minTarget = Math.round(max * 0.50f);
        int maxTarget = Math.round(max * 0.85f);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        int idade = pessoa.calculateAge(LocalDate.now().getYear());
        int maxHR = pessoa.calculateMaxHeartRate();
        String alvo = pessoa.calculateTargetHeartRate();

        System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n",
                pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + alvo);

        sc.close();
    }
}