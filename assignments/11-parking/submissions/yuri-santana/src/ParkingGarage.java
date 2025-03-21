
import java.util.Scanner;

public class ParkingGarage {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double c = 0;
      while (true) { 
        c = Double.parseDouble(scanner.nextLine());
        if(c == -1) break;
        System.out.println(calculateCharges(c));
      }
  }

  public static double calculateCharges(double hours){
    if(hours <= 3.0) return 2.0;
    else if(hours >= 24.0) return 10.0;
    else return (2 + (0.5) * Math.ceil((hours - 3)));
  }
}
