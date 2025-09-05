import java.util.Scanner;

public class HeartRatesApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        input.close();

        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);
 
        int age = pessoa.calculateAge();
        int maxHeartRate = pessoa.calculateMaxHeartRate();
        int[] targetHeartRate = pessoa.calculateTargetHeartRate();

        System.out.println("\n--- Resumo ---");
        System.out.printf("Nome: %s %s\n", pessoa.getFirstName(), pessoa.getLastName());
        System.out.printf("Data de nascimento: %d/%d/%d\n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", age);
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", maxHeartRate);
        System.out.printf("Faixa de frequência cardíaca alvo: %d bpm - %d bpm\n", targetHeartRate[0], targetHeartRate[1]);
    }
}