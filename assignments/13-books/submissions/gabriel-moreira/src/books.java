
class Book {
    private String titulo;
    private int ano;
    private String autor;

    public Book(String titulo, int ano, String autor) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
    }

    
    public String toString() {
        return titulo + " - " + autor + " (" + ano + ")";
    }
}


class PrintBook extends Book {
    private String editora;
    private String isbn;

    public PrintBook(String titulo, int ano, String autor, String editora, String isbn) {
        super(titulo, ano, autor);
        this.editora = editora;
        this.isbn = isbn;
    }

    
    public String toString() {
        return super.toString() + " | Editora: " + editora + " | ISBN: " + isbn;
    }
}


class AudioBook extends Book {
    private double tamanhoMB;
    private int duracaoMin;
    private String narrador;

    public AudioBook(String titulo, int ano, String autor, double tamanhoMB, int duracaoMin, String narrador) {
        super(titulo, ano, autor);
        this.tamanhoMB = tamanhoMB;
        this.duracaoMin = duracaoMin;
        this.narrador = narrador;
    }

    
    public String toString() {
        return super.toString() + " | " + tamanhoMB + "MB, " + duracaoMin + "min | Narrador: " + narrador;
    }
}


public class BookApp {
    public static void main(String[] args) {
        Book b1 = new Book("Java: How to Program", 2017, "Deitel & Deitel");
        PrintBook b2 = new PrintBook("Java: How to Program", 2017, "Deitel & Deitel", "Pearson", "978-0-13-474335-6");
        AudioBook b3 = new AudioBook("Java: How to Program", 2017, "Deitel & Deitel", 850.5, 960, "John Smith");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
