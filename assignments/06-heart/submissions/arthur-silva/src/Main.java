import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Dia de nascimento: ");
        int day = sc.nextInt();

        System.out.print("Mês de nascimento: ");
        int month = sc.nextInt();

        System.out.print("Ano de nascimento: ");
        int year = sc.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nInformações:");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        int idade = person.calculateAge(2025);
        System.out.println("Idade em 2025: " + idade + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());
    }
}