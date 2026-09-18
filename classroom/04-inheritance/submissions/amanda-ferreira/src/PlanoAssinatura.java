public class PlanoAssinatura {
    private String nome;
    private double mensalidade;

    public PlanoAssinatura(String nome, double mensalidade){
        if(nome == null || nome.isBlank()){
            this.nome = "Plano sem nome";
        } else{
            this.nome = nome;
        }

        if(mensalidade < 0){
            this.mensalidade = 0.0;
        } else{
            this.mensalidade = mensalidade;
        }
    }

    public String obterNome(){
        return this.nome;
    }

    public double obterMensalidade(){
        return this.mensalidade;
    }

    public String obterDescricao(){
        return this.nome + " - R$" + this.mensalidade;
    }
}