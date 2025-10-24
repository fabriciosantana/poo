public class Phone {
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        if (serialNumber == null || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }

        this.name = name;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Phone [Nome: '" + name + "', Serial: '" + serialNumber + "']";
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}