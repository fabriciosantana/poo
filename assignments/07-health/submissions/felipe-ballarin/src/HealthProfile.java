public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInches = heightInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public double getHeightInches() { return heightInches; }
    public void setHeightInches(double heightInches) { this.heightInches = heightInches; }

    public double getWeightInPounds() { return weightInPounds; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }

    public int calculateAge(int currentYear) {
        return currentYear - this.yearOfBirth;
    }

    public int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    public String calculateTargetHeartRate(int HeartRatemaximo) {
        int minTarget = (int) (HeartRatemaximo * 0.50);
        int maxTarget = (int) (HeartRatemaximo * 0.85);
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }

    public double calculateBMI() {
        return (getWeightInPounds() * 703) / (getHeightInches() * getHeightInches());
    }
}

