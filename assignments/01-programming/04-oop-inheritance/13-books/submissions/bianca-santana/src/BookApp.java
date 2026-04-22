class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, year);
    }
}

class PrintBook extends Book {

    private String publisher;
    private String isbn;

    public PrintBook(String title, String author, int year, String publisher, String isbn) {
        super(title, author, year);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("%s, published by %s (ISBN: %s)", super.toString(), publisher, isbn);
    }
}

class AudioBook extends Book {

    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, String author, int year, String narrator, double fileSizeInMB, int playLengthInMinutes) {
        super(title, author, year);
        this.narrator = narrator;
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
    }

    public String getNarrator() {
        return narrator;
    }

    public double getFileSizeInMB() {
        return fileSizeInMB;
    }

    public int getPlayLengthInMinutes() {
        return playLengthInMinutes;
    }

    @Override
    public String toString() {
        return String.format("%s, narrated by %s (%.2f MB, %d minutes)", super.toString(), narrator, fileSizeInMB, playLengthInMinutes);
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("A Arte Da Guerra", "Sun Tzu", 2023);
        PrintBook printBook = new PrintBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Scribner", "978-0743273565");
        AudioBook audioBook = new AudioBook("Harry Potter e a Pedra Filosofa", "J.K. Rowling", 1997, "Sissy Spacek", 500.0, 780);

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}