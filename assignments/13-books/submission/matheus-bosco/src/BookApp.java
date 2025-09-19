// Classe base
class Book {
    private String title;
    private int year;
    private String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Ano: %d", title, author, year);
    }
}

// Subclasse para livros impressos
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
        return super.toString() +
               String.format(" | Editora: %s | ISBN: %s", publisher, isbn);
    }
}

// Subclasse para audiolivros
class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author,
                     double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format(" | Tamanho: %.1fMB | Duração: %dmin | Narrador: %s",
                             fileSizeInMB, playLengthInMinutes, narrator);
    }
}

// Classe principal
public class BookApp {
    public static void main(String[] args) {
        Book generic = new Book("Programação em Java", 2017, "Paul Deitel");
        PrintBook printed = new PrintBook("Java: How to Program", 2017, "Paul & Harvey Deitel",
                                          "Pearson", "978-0-13-474335-6");
        AudioBook audio = new AudioBook("Clean Code", 2008, "Robert C. Martin",
                                        450.5, 720, "John Doe");

        System.out.println(generic);
        System.out.println(printed);
        System.out.println(audio);
    }
}
