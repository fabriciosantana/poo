package zoo;

class Canine {} 
class Dog extends Canine {} 
class Wolf extends Canine {} 
final class Husky extends Dog {} 

public class Zoologist {
    Canine animal;
    public final void setAnimal(Dog animal) { this.animal = animal; }
    public static void main(String[] furryFriends) {
        new Zoologist().setAnimal(new Dog());
    } 
}
