public class Elevador {
    private int andarAtual;
    private int ultimoAndar;
    private int capacidade;
    private int quantidadePessoas;

    public Elevador(int ultimoAndar, int capacidade) {
        if (ultimoAndar > 0) {
            this.ultimoAndar = ultimoAndar;
        } else {
            this.ultimoAndar = 1;
        }

        if (capacidade > 0) {
            this.capacidade = capacidade;
        } else {
            this.capacidade = 1;
        }

        this.andarAtual = 0;
        this.quantidadePessoas = 0;
    }

    public boolean entrar(int quantidade) {
        if (quantidade > 0 && (this.quantidadePessoas + quantidade) <= this.capacidade) {
            this.quantidadePessoas += quantidade;
            return true;
        }
        return false;
    }

    public boolean sair(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidadePessoas) {
            this.quantidadePessoas -= quantidade;
            return true;
        }
        return false;
    }

    public boolean subir() {
        if (this.andarAtual < this.ultimoAndar) {
            this.andarAtual++;
            return true;
        }
        return false;
    }

    public boolean descer() {
        if (this.andarAtual > 0) {
            this.andarAtual--;
            return true;
        }
        return false;
    }

    public int obterAndarAtual() {
        return this.andarAtual;
    }

    public int obterUltimoAndar() {
        return this.ultimoAndar;
    }

    public int obterCapacidade() {
        return this.capacidade;
    }

    public int obterQuantidadePessoas() {
        return this.quantidadePessoas;
    }
}