import java.util.Scanner;
import java.time.LocalDate;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        LocalDate today = LocalDate.now();
        int age = today.getYear() - year;
        if (today.getMonthValue() < month || (today.getMonthValue() == month && today.getDayOfMonth() < day)) {
            age--;
        }

        int maxHeartRate = 220 - age;
        int minTarget = (int)(maxHeartRate * 0.5);
        int maxTarget = (int)(maxHeartRate * 0.85);

        System.out.println("\nNome: " + firstName + " " + lastName);
        System.out.println("Data de nascimento: " + String.format("%02d/%02d/%04d", day, month, year));
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + minTarget + " bpm - " + maxTarget + " bpm");
    }
}
