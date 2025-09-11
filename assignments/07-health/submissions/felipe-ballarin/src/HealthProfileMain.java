import java.util.Scanner;

public class HealthProfileMain {
    public static void main(String[] args) {

        final int CURRENT_YEAR = 2025;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        
        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        input.close();

        HealthProfile userProfile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int age = userProfile.calculateAge(CURRENT_YEAR);
        int HeartRatemaximo = userProfile.calculateMaxHeartRate(age);
        String targetHeartRate = userProfile.calculateTargetHeartRate(HeartRatemaximo);
        double bmi = userProfile.calculateBMI();

        System.out.println();
        System.out.printf("Nome: %s %s\n", userProfile.getFirstName(), userProfile.getLastName());
        
        if (userProfile.getGender() == 'M' || userProfile.getGender() == 'm') {
            System.out.println("Gênero: Masculino");
        } else {
            System.out.println("Gênero: Feminino");
        }
        
        System.out.printf("Data de nascimento: %d/%d/%d\n", userProfile.getDayOfBirth(), userProfile.getMonthOfBirth(), userProfile.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", age);
        System.out.printf("Altura: %.0f polegadas\n", userProfile.getHeightInches());
        System.out.printf("Peso: %.0f libras\n", userProfile.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", HeartRatemaximo);
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", targetHeartRate);
        
        System.out.println("\nBMI              Classificação");
        System.out.println("Menos de 18.5    Abaixo do peso");
        System.out.println("18.5 - 24.9      Peso normal");
        System.out.println("25.0 - 29.9      Sobrepeso");
        System.out.println("30.0 ou mais     Obesidade");
    }
}