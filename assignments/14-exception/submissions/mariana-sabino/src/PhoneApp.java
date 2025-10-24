public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone p1 = new Phone("", "1567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone p2 = new Phone("Xiaomi", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone p3 = new Phone("Iphone", "0836489309726357");
            System.out.println("Telefone criado com sucesso: " + p3.getName());
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
