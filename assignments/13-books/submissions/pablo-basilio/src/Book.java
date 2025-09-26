public class Book {
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
        return String.format("Título: %s, Autor: %s, Ano: %d", title, author, year);
    }
    
    public static void main(String[] args) {
        System.out.println("--- menu ---");

        Book book = new Book("basico", 2020, "Autor 1");
        PrintBook pBook = new PrintBook("Impresso", 1990, "Autor 2", "Editora X", "978-40028922");
        AudioBook aBook = new AudioBook("Audio", 2010, "Autor 3", 150.0, 300, "Narrador Y");

        System.out.println("\n Book: \n" + book);
        System.out.println("\n PrintBook: \n" + pBook);
        System.out.println("\n AudioBook: \n" + aBook);
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
        return String.format("%s, Editora: %s, ISBN: %s", super.toString(), publisher, isbn);
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
        return String.format("%s, Tamanho: %.1fMB, Duração: %dmin, Narrador: %s", 
                              super.toString(), fileSizeInMB, playLengthInMinutes, narrator);
    }
}