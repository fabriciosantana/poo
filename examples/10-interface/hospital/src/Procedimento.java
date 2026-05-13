public class Procedimento {
    private String nome;
    private double valor;

    public Procedimento(String n, double v){
        this.nome = n;
        this.valor = v;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return "\n - " + this.nome + ": " + "R$ " + this.valor;
    }
}
