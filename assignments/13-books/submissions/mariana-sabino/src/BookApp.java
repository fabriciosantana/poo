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
        return "Título: " + title + ", Autor: " + author + ", Ano: " + year;
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
        return super.toString() + ", Tamanho do arquivo: " + fileSizeInMB + " MB, Duração: "
                + playLengthInMinutes + " minutos, Narrador: " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("O Senhor dos Anéis", 1954, "J.R.R. Tolkien");
        PrintBook battleRoyale = new PrintBook("Battle Royale", 1999, "Koushun Takami", "Ohta Publishing", "978-4-87233-452-0");
        AudioBook it = new AudioBook("IT", 1986, "Stephen King", 750.5, 1260, "Steven Weber");

        System.out.println(genericBook);
        System.out.println(battleRoyale);
        System.out.println(it);
    }
}
