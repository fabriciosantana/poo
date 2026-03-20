import java.util.Scanner;

public class HeartRates {
    
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

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
    int anoAtual = 2026; 
    return 220 - calculateAge(anoAtual);
    }


    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate(); 
        double minAlvo = max * 0.5;
        double maxAlvo = max * 0.85;
        return String.format("%.0f bpm - %.0f bpm", minAlvo, maxAlvo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anoAtual = 2026;

        System.out.print("Digite seu primeiro nome: ");
        String f = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String l = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        int y = scanner.nextInt();

        HeartRates pessoa = new HeartRates(f, l, d, m, y);

        System.out.println("\nNome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %d/%d/%d\n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", pessoa.calculateAge(anoAtual));
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", pessoa.calculateMaxHeartRate(anoAtual));
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n",pessoa.calculateTargetHeartRate(anoAtual));

        scanner.close();
    }
}