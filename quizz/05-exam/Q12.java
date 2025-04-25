class Building {} 
class House extends Building{} 

public class Q12{
    public static void main(String[] args) { 
        Building b =  new Building(); 
        House h = new House(); 
        Building bh = new House(); 
        //House p = (House) b; 
        House q = (House) h; 
        House r = (House) bh; 
    }    
}

