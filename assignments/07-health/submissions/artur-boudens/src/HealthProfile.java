import java.time.LocalDate;

public class HealthProfile {
    
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender; 
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public void setDayOfBirth(int dayOfBirth){
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth){
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public void setHeightInInches(double heightInInches){
        this.heightInInches = heightInInches;
    }

    public void setWeightInPounds(double weightInPounds){
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public char getGender(){
        return gender;
    }

    public int getDayOfBirth(){
        return dayOfBirth;
    }

    public int getMonthOfBirth(){
        return monthOfBirth;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }

    public double getHeightInInches(){
        return heightInInches;
    }
    
    public double getWeightInPounds(){
        return weightInPounds;
    }

    int currentYear = LocalDate.now().getYear();
    
    public int calculateAge(){
        return LocalDate.now().getYear() - this.yearOfBirth;
    }

    public int calculateMaxHeartRate(){
        return 220 - calculateAge();
    }

    public int[] calculateTargetHeartRate(){
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) (maxRate * 0.5);
        int maxTarget = (int) (maxRate * 0.85);

        return new int[]{minTarget, maxTarget};
    }

    public double calculateBMI(){
        return (this.weightInPounds * 703) / (this.heightInInches * this.heightInInches);
    }


}
