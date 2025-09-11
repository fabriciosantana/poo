import java.time.LocalDate;

public class HeartRates{

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
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

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
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

}