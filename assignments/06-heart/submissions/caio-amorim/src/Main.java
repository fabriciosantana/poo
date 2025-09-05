import java.util.Scanner;
import java.time.LocalDate;

class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor
    public HeartRates(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }

    // Métodos Get e Set
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

    // Método para calcular idade
    public int calculateAge() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - yearOfBirth;

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

    // Frequência cardíaca alvo (retorna String para simplicidade)
    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int)(max * 0.50);
        int maxTarget = (int)(max * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite sua data de nascimento (dia mes ano): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        // Criando objeto
        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        // Saída
        System.out.println("\n--- Informações ---");
        System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.println("Data de nascimento: " + pessoa.getDayOfBirth() + "/" + pessoa.getMonthOfBirth() + "/" + pessoa.getYearOfBirth());
        System.out.println("Idade: " + pessoa.calculateAge() + " anos");
        System.out.println("Frequência cardíaca máxima: " + pessoa.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + pessoa.calculateTargetHeartRate());

        sc.close();
    }
}
