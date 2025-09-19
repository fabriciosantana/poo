import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender,
                day, month, year, height, weight);

        System.out.println("\n Nome: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Gênero: " + patient.getGenderFull());
        System.out.println("Data de nascimento: " + patient.getDayOfBirth() + "/" +
            patient.getMonthOfBirth() + "/" + patient.getYearOfBirth());
        System.out.println("Idade: " + patient.calculateAge(java.time.Year.now().getValue()) + " anos");
        System.out.println("Altura: " + patient.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + patient.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", patient.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + patient.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + patient.calculateTargetHeartRate());

        System.out.println("\n Tabela de Referência do BMI ");
        System.out.println("Menos de 18.5: Abaixo do peso");
        System.out.println("18.5 – 24.9: Peso normal");
        System.out.println("25.0 – 29.9: Sobrepeso");
        System.out.println("30.0 ou mais: Obesidade");

        scanner.close();
    }
}