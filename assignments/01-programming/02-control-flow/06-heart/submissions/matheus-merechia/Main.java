import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        int idade = pessoa.calculateAge(LocalDate.now().getYear());
        int maxHR = pessoa.calculateMaxHeartRate();
        String faixa = pessoa.calculateTargetHeartRate();

        System.out.println("\nNome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", day, month, year);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + faixa);

        scanner.close();
    }
}
    

