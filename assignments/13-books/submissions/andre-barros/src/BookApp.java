class Book {
    protected String title;
    protected int year;
    protected String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Título: " + title + ", Ano: " + year + ", Autor: " + author;
    }
}

class PrintBook extends Book {
    private String publisher;
    private String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + ", Editora: " + publisher + ", ISBN: " + isbn;
    }
}

class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho do arquivo: " + fileSizeInMB + "MB"
                + ", Duração: " + playLengthInMinutes + " minutos"
                + ", Narrador: " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book livro = new Book("Java How to Program", 2017, "Paul Deitel");
        PrintBook livroImpresso = new PrintBook("Clean Code", 2009, "Robert C. Martin", "Pearson", "978-0132350884");
        AudioBook audioLivro = new AudioBook("O Hobbit", 1937, "J.R.R. Tolkien", 350.5, 720, "Fernanda Montenegro");

        System.out.println(livro.toString());
        System.out.println(livroImpresso.toString());
        System.out.println(audioLivro.toString());
    }
}