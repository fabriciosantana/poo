
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
            return super.toString() + ", Tamanho: " + fileSizeInMB + "MB, Duração: " + playLengthInMinutes + "min, Narrador: " + narrator;
        }
}

public class BookApp {
         public static void main(String[] args) {
        Book genericBook = new Book("Java Basics", 2020, "John Doe");
        PrintBook printBook = new PrintBook("Effective Java", 2018, "Joshua Bloch", "Addison-Wesley", "978-0134685991");
        AudioBook audioBook = new AudioBook("Clean Code", 2008, "Robert C. Martin", 512.5, 750, "John Smith");

            System.out.println(genericBook);
            System.out.println(printBook);
            System.out.println(audioBook);
    }
}