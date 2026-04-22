class Livro {
    protected String titulo;
    protected int ano;
    protected String autor;

    public Livro(String titulo, int ano, String autor) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
    }

    public String toString() {
        return titulo + " (" + ano + ") - " + autor;
    }
}

class LivroImpresso extends Livro {
    private String editora;
    private String isbn;

    public LivroImpresso(String titulo, int ano, String autor, String editora, String isbn) {
        super(titulo, ano, autor);
        this.editora = editora;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + " [Editora: " + editora + ", ISBN: " + isbn + "]";
    }
}

class AudioLivro extends Livro {
    private double tamanhoMB;
    private int duracao;
    private String narrador;

    public AudioLivro(String titulo, int ano, String autor, double tamanhoMB, int duracao, String narrador) {
        super(titulo, ano, autor);
        this.tamanhoMB = tamanhoMB;
        this.duracao = duracao;
        this.narrador = narrador;
    }

    @Override
    public String toString() {
        return super.toString() + " [Audio: " + duracao + "min, Narrador: " + narrador + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Livro b1 = new Livro("Clean Code", 2008, "Robert C. Martin");
        
        LivroImpresso b2 = new LivroImpresso("Effective Java", 2018, "Joshua Bloch", "Addison-Wesley", "978-0134685991");
        
        AudioLivro b3 = new AudioLivro("Atomic Habits", 2018, "James Clear", 350.5, 320, "James Clear");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
