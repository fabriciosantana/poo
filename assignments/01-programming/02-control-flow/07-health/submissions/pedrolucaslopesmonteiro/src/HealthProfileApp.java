import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender,
                                                   day, month, year, height, weight);

        int age = profile.calculateAge(2025);
        int maxHR = profile.calculateMaxHeartRate();
        int[] target = profile.calculateTargetHeartRate();
        double bmi = profile.calculateBMI();
        String genderStr = (profile.getGender() == 'M') ? "Masculino" : "Feminino";

        System.out.println("\nNome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + genderStr);
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", profile.getDayOfBirth(), profile.getMonthOfBirth(), profile.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + (int)profile.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + (int)profile.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + target[0] + " bpm - " + target[1] + " bpm");

        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("Menos de 18.5  → Abaixo do peso");
        System.out.println("18.5 – 24.9    → Peso normal");
        System.out.println("25.0 – 29.9    → Sobrepeso");
        System.out.println("30.0 ou mais   → Obesidade");

        scanner.close();
    }
}