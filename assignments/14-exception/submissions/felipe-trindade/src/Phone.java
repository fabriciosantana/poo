public class Phone{
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException{
        checkName(name);
        checkSerial(serialNumber);

        this.name = name;
        this.serialNumber = serialNumber;
    }

    private void checkName(String name) throws ValidationException{
        if(name == null || name.trim().isEmpty()){
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
    }

    private void checkSerial(String serial) throws ValidationException{
        if(serial == null || serial.trim().isEmpty() || serial.length() != 16){
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }
    }

    public String getName(){
        return name;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    @Override
    public String toString(){
        return "Telefone: " + name + " | Série: " + serialNumber;
    }
}
