public abstract class ArrayIndexOutOfBound {
    public static void main(String[] args){

        String[] students = {"John", "Paul"};	
        
        int outOfBoundIndex = 2; // students[0] = "John", students[1] = "Paul"

        try{
            System.out.println(students[outOfBoundIndex]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("Student %s does not exist%n", outOfBoundIndex);
            System.out.println(e);
        }

        System.out.println("Program continues execution ...");

    }
}
