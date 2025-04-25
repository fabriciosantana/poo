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

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    
    public int calculateMaxHeartRate() {
        int age = calculateAge(java.time.Year.now().getValue());
        return 220 - age;
    }

    
    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Digite seu primeiro nome: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Digite seu sobrenome: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            
            HeartRates person = new HeartRates(firstName, lastName, day, month, year);
            
            
            int currentYear = java.time.Year.now().getValue();
            
            
            int age = person.calculateAge(currentYear);
            int maxHeartRate = person.calculateMaxHeartRate();
            String targetHeartRate = person.calculateTargetHeartRate();
            
            
            System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
            System.out.printf("Data de nascimento: %02d/%02d/%d\n", 
                person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
            System.out.println("Idade: " + age + " anos");
            System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate);
        }
    }
}