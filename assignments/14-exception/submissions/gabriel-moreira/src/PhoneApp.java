ppublic class PhoneApp {

    public static void main(String[] args) {

        
        try {
            System.out.println("Tentativa 1: Nome vazio...");
            Phone p1 = new Phone("", "1234567890123456");
            System.out.println("Sucesso: " + p1.getName()); 
        } catch (ValidationException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        
        System.out.println("------------------------------------");

        
        try {
            System.out.println("Tentativa 2: Número de série com 5 dígitos...");
            Phone p2 = new Phone("Modelo X", "12345"); 
            System.out.println("Sucesso: " + p2.getName()); 
        } catch (ValidationException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("------------------------------------");

        
        try {
            System.out.println("Tentativa 3: Dados válidos...");
            Phone p3 = new Phone("Modelo Y Pro", "ABCDEF0123456789");
            System.out.println("Sucesso! Telefone criado: " + p3.getName() + " (S/N: " + p3.getSerialNumber() + ")");
        } catch (ValidationException e) {
            System.err.println("Erro inesperado: " + e.getMessage()); 
        }
    }
}