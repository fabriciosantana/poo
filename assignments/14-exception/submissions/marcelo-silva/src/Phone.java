
public class Phone {
    private String name;
    private String serialNumber;

    
    public Phone(String name, String serialNumber) throws ValidationException {

        // Validação do nome: verifica se é nulo ou se está vazio (após remover espaços)
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");

        }

        // Validação do número de série: verifica se é nulo ou se o tamanho é diferente de 16
        if (serialNumber == null || serialNumber.length() != 16) {

            throw new ValidationException("O número de série deve conter exatamente 16 caracteres.");
            
        }

        // Se todas as validações passarem, inicializa os atributos.
        this.name = name;
        this.serialNumber = serialNumber;
    }

    // Métodos getters para acessar os atributos privados (boa prática)
    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
