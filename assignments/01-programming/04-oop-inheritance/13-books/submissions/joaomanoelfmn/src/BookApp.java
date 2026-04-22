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
        return "Book: '" + title + "' | Author: " + author + " | Year: " + year;
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
        return super.toString() + " | Format: PrintBook | Publisher: " + publisher + " | ISBN: " + isbn;
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
        return super.toString() + " | Format: AudioBook | Size: " + fileSizeInMB + "MB | Length: " + playLengthInMinutes + " mins | Narrator: " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("The Mythical Man-Month", 1975, "Fred Brooks");

        PrintBook printBook = new PrintBook(
            "Java: How to Program, Early Objects", 
            2017, 
            "Paul Deitel, Harvey Deitel", 
            "Pearson", 
            "978-0-13-474335-6"
        );

        AudioBook audioBook = new AudioBook(
            "Clean Code", 
            2008, 
            "Robert C. Martin", 
            350.5, 
            640, 
            "Margarita Narrator"
        );

        System.out.println("--- Lista de Livros ---");
        System.out.println(genericBook.toString());
        System.out.println(printBook.toString());
        System.out.println(audioBook.toString());
    }
}