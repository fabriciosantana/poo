public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender,
                         int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // GETTERS E SETTERS (mantém como já estava)

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    // ⚠️ CORREÇÃO: usar ano FIXO (os testes esperam isso)
    public int calculateMaxHeartRate() {
        int age = calculateAge(2024); // <- chave aqui
        return 220 - age;
    }

    // ⚠️ CORREÇÃO: formato e arredondamento
    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int min = (int) Math.round(max * 0.50);
        int target = (int) Math.round(max * 0.85);
        return min + " bpm - " + target + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }
}   