public class Phone {
    
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {

        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("o nome do telefone não pode estar vazio.");
        
        }


        if (serialNumber == null || serialNumber.trim().isEmpty() || serialNumber.length() != 16) {
            throw new ValidationException("o numero de serie deve conter exatamente 16 digitos.");
        }

        this.name = name;
        this.serialNumber = serialNumber;
        
        System.out.println("-> telefone '" + name + "' criado com sucesso. serie: " + serialNumber);
    }


    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
