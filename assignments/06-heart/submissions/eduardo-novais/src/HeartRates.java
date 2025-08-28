import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
    }

    public HeartRates setBirthDate(int day, int month, int year) { 
        this.dayOfBirth = dayOfBirth; 
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;

        return this;
    }

    public static void main(String[] args) {
        int option;

        Scanner input = new Scanner(System.in);

        System.out.println("\n==============================\n\n");
        System.out.println("1 - Cadastra-se\n");
        System.out.println("2 - Calcular Idade\n");
        System.out.println("3 - Calcular Frequência Cardíaca Máxima\n");
        System.out.println("3 - Calcular Faixa Frequência Cardíaca Alvo (Mínimo e Máximo)\n");
        System.out.println("0 - Sair\n\n");
        System.out.println("\n==============================\n");

        option = input.nextInt();
        input.nextLine();

        do {
            switch (option) {
                case 1;
                    System.out.println("Digite seu primeiro nome: ");
                    firstName = input.nextLine();

                    System.out.println("Digite seu sobrenome: ");
                    lastName = input.nextLine();

                    System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();

                    HeartRates person = new HeartRates(firstName, lastName).setBirthDate(day, month, year);

                    System.out.println("Cadastro realiado com sucesso!");
    
                    break;
                case 2;
                    int age calculateAge(year);

                    System.out.println("Idade: %d anos", age);
                    break;
                case 3;
                    break;
                case 4;
                    break;
                case 0;
                    break;
                default;
                    break;
            }
        } while (option != 0);
    }

    public static int calculateAge(int curruntYear) {

    }

    public static void calculateMaxHeartRate() {

    }

    public static void calculateTargetHeartRate() {

    }
}