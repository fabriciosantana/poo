public class Phone {
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException{
        validateName(name);
        validateSerialNumber(serialNumber);

        this.name = name;
        this.serialNumber = serialNumber;
    }

    private void validateName(String name) throws ValidationException{
        if(name == null || name.isEmpty()){
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
    }

    private void validateSerialNumber(String serialNumber) throws ValidationException{
        if(serialNumber == null || serialNumber.isEmpty() || serialNumber.length() != 16){
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }
    }

    public String getName(){
        return this.name;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }
}
