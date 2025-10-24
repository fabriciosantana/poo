public class PhoneApp {
    
    public static void main(String[] args) {
        
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Phone phone2 = new Phone("iPhone", "12345");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Phone phone3 = new Phone("Samsung", "1234567890123456");
            System.out.println("Telefone criado com sucesso");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

