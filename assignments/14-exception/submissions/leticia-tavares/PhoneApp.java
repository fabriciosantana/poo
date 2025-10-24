public class PhoneApp {

    public static void main(String[] args) {
        
        System.out.println("teste 1: nome vazio");
        try {
            Phone invalidPhone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.err.println("excecao capturada (nome vazio): " + e.getMessage());
        }
        
        System.out.println("\n teste 2: numero de serie invalido (curto)");
        try {
            Phone invalidPhone2 = new Phone("galaxy S25", "12345");
        } catch (ValidationException e) {
            System.err.println("excecao capturada (serie Curta): " + e.getMessage());
        }
        
        System.out.println("\n teste 3: dados validos");
        try {
            Phone validPhone = new Phone("iphone 20", "AABBCCDD11223344");
            
            System.out.println("SUCESSO: o telefone foi instanciado corretamente.");
            
        } catch (ValidationException e) {
            System.err.println("ERRO INESPERADO: " + e.getMessage());
        }
    }
}