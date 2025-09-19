import java.util.Scanner;
import java.time.LocalDate;

class HeartRates {
    // Atributos privados
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Getters e Setters
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

    // Calcula idade com base no ano/mês/dia atuais
    public int calculateAge() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - yearOfBirth;

        // Ajusta se ainda não fez aniversário no ano atual
        if (hoje.getMonthValue() < monthOfBirth || 
           (hoje.getMonthValue() == monthOfBirth && hoje.getDayOfMonth() < dayOfBirth)) {
            idade--;
        }
        return idade;
    }

    // Frequência cardíaca máxima
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    // Faixa de frequência cardíaca alvo (mín e máx)
    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int)(maxHR * 0.50);
        int maxTarget = (int)(maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }
}

public class HeartRatesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        // Cria objeto
        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        // Saída
        System.out.println("\nNome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.println("Idade: " + pessoa.calculateAge() + " anos");
        System.out.println("Frequência cardíaca máxima: " + pessoa.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + pessoa.calculateTargetHeartRate());

        scanner.close();
    }
}
