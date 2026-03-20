import java.time.LocalDate;
import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu genero (M/F): ");
        char gender = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaco): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HealthProfile person = new HealthProfile(
            firstName,
            lastName,
            gender,
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            heightInInches,
            weightInPounds
        );

        int currentYear = LocalDate.now().getYear();
        int age = person.calculateAge(currentYear);
        int maxHeartRate = person.calculateMaxHeartRate(currentYear);
        int[] targetHeartRate = person.calculateTargetHeartRate(currentYear);
        double bmi = person.calculateBMI();

        System.out.println();
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Genero: " + getGenderDescription(person.getGender()));
        System.out.printf(
            "Data de nascimento: %02d/%02d/%04d%n",
            person.getDayOfBirth(),
            person.getMonthOfBirth(),
            person.getYearOfBirth()
        );
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");
        System.out.printf("Indice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequencia cardiaca maxima: " + maxHeartRate + " bpm");
        System.out.println(
            "Faixa de frequencia cardiaca alvo: " + targetHeartRate[0] + " bpm - " + targetHeartRate[1] + " bpm"
        );

        System.out.println();
        System.out.println("Tabela de referencia do BMI:");
        System.out.println("Menos de 18.5 - Abaixo do peso");
        System.out.println("18.5 - 24.9 - Peso normal");
        System.out.println("25.0 - 29.9 - Sobrepeso");
        System.out.println("30.0 ou mais - Obesidade");

        scanner.close();
    }

    public static String getGenderDescription(char gender) {
        if (gender == 'M') {
            return "Masculino";
        }
        if (gender == 'F') {
            return "Feminino";
        }
        return "Nao informado";
    }
}
