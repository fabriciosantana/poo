public final class Phone {

    private final String name;
    private final String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        String n = (name == null) ? null : name.trim();
        String s = (serialNumber == null) ? null : serialNumber.trim();

        if (n == null || n.isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
        if (s == null || s.isEmpty() || !s.matches("\\d{16}")) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }

        this.name = n;
        this.serialNumber = s;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Phone{name='" + name + "', serialNumber='" + serialNumber + "'}";
    }
}
