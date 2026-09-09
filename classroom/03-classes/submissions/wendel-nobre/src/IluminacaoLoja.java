public class IluminacaoLoja {
    private String setor;
    private double poteciawatts;
    private boolean ligada;
    
    public IluminacaoLoja(String setor, double poteciawatts) {
        if (setor == null || setor.trim().isEmpty()) {
            this.setor = "Setor não informado";
        } else {
            this.setor = setor;
        }   
        if(poteciawatts <= 0) {
            this.poteciawatts = 10.0;
        } else {
            this.poteciawatts = poteciawatts;
        }

        this.ligada = false;
    }

    public void ligar() {
        this.ligada = true;
    }

    public void desligar() {
        this.ligada = false;
    }

    public String obterSetor() {
        return this.setor;
    }

    public double obterPoteciawatts() {
        return this.poteciawatts;
    }

    public boolean estaLigada() {
        return this.ligada;
    }
}