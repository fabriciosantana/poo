// classe que representa  telefone
public class Phone {

    private String name;
    private String serialNumber;

    // construtor com validacao
    public Phone(String name, String serialNumber) throws ValidationException {

        // valida nome
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        // valida numero de serie
        if (serialNumber == null || serialNumber.trim().isEmpty() || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }

        this.name = name;
        this.serialNumber = serialNumber;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
