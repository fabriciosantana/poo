import java.time.Year;
import java.util.Scanner;

public class HeartRates { 

    
    
    public static class HeartRateCalculator {
        private String firstName;
        private String lastName;
        private int dayOfBirth;
        private int monthOfBirth;
        private int yearOfBirth;

        // Construtor
        public HeartRateCalculator(String firstName, String lastName,
                                 int dayOfBirth, int monthOfBirth, int yearOfBirth) {
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

        // Idade em anos
        public int calculateAge() {
            return Year.now().getValue() - yearOfBirth;
        }

        // Frequência cardíaca máxima
        public int calculateMaxHeartRate() {
            return 220 - calculateAge();
        }

        // Faixa de frequência cardíaca alvo
        public String calculateTargetHeartRate() {
            int max = calculateMaxHeartRate();
            int min = (int) Math.round(max * 0.50);
            int maxTarget = (int) Math.round(max * 0.85);
            return min + " bpm - " + maxTarget + " bpm";
        }
    }

    // ---------- Programa Principal ----------
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite seu primeiro nome: ");
            String firstName = sc.nextLine();
            
            System.out.print("Digite seu sobrenome: ");
            String lastName = sc.nextLine();
            
            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            
            // Agora, use o novo nome da classe
            HeartRateCalculator person = new HeartRateCalculator(firstName, lastName, day, month, year);
            
            System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
            System.out.printf("Data de nascimento: %02d/%02d/%d%n",
                    person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
            System.out.println("Idade: " + person.calculateAge() + " anos");
            System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());
        }
    }
}