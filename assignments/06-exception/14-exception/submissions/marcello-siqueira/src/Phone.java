public class Phone {

    private static final int SERIAL_NUMBER_LENGTH = 16;

    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        // o README pede apenas o comprimento: nulo, vazio ou diferente de 16 caracteres
        if (serialNumber == null || serialNumber.length() != SERIAL_NUMBER_LENGTH) {
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
