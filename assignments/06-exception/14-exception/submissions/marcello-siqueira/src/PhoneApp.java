public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("Teste 1: telefone com nome vazio");
        tryCreatePhone("", "1234567890123456");

        System.out.println();
        System.out.println("Teste 2: número de série com menos de 16 dígitos");
        tryCreatePhone("Motorola", "12345");

        System.out.println();
        System.out.println("Teste 3: telefone com dados válidos");
        tryCreatePhone("Nokia", "1234567890123456");
    }

    private static void tryCreatePhone(String name, String serialNumber) {
        try {
            Phone phone = new Phone(name, serialNumber);
            System.out.println("Telefone criado com sucesso: " + phone.getName()
                    + " (número de série " + phone.getSerialNumber() + ")");
        } catch (ValidationException exception) {
            System.out.println("Erro ao criar o telefone: " + exception.getMessage());
        }
    }
}
