public class PhoneApp{
    public static void main(String[] args){
        try{
            Phone p1 = new Phone("", "1111111111111111");
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try{
            Phone p2 = new Phone("Samsung", "123");
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try{
            Phone p3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso!");
            System.out.println(p3);
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try{
            Phone p4 = new Phone(null, "1234567890123456");
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try{
            Phone p5 = new Phone("Motorola", null);
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try{
            Phone p6 = new Phone("LG", "12345678901234567");
        }catch(ValidationException e){
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nFim dos testes.");
    }
}