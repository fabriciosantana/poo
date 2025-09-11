public class Student {

    private String name;
    private int age;            //scaner  
    private String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;             //contrutor 
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return String.format("Student: %s%nAge: %d%nCourse: %s", getName(), getAge(), getCourse());
    }

}
