import java.time.LocalDate;

public class HeartRates {

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        int idade = calculateAge(LocalDate.now().getYear());
        return 220 - idade;
    }

    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int) (max * 0.50);
        int maxTarget = (int) (max * 0.85);

        return minTarget + " bpm - " + maxTarget + " bpm";
    }
}