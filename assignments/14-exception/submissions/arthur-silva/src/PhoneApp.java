public class PhoneApp {
    public static void main(String[] args) {
        try{
            Phone phone1 = new Phone("", "1111111111111111");
        }catch(ValidationException e){
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            Phone phone2 = new Phone("Samsung", "999");
        } catch (ValidationException e){
            System.err.println("Erro: " + e.getMessage());
            System.err.println("Causa do erro: " + e.getCause());
        }

        try {
            Phone phone3 = new Phone("Iphone", "9999999999999999");
            System.out.println("Celular adicionado com sucesso! -Nome:  " + phone3.getName() + ". -Número de série: " + phone3.getSerialNumber());
        } catch (ValidationException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
