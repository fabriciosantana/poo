package edu; 

class School {
    public int getNumberOfStudentsPerClassroom(String[] students) {
        return 3;
    }

    public int getNumberOfStudentsPerClassroom() {
        return 9;
    } 
} 

public class HighSchool extends School {
    @Override
    public int getNumberOfStudentsPerClassroom() {
        return 2;
    }
    public static void main(String[] students) {
        School school = new HighSchool();
        System.out.print(school.getNumberOfStudentsPerClassroom());
    }
}