public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone p2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone p3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso: " + p3.getName() + " - " + p3.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Phone {
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
        if (serialNumber == null || serialNumber.trim().isEmpty() || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
