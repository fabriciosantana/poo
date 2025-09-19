
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
        return super.toString() + ", Tamanho: " + fileSizeInMB + "MB, Duração: " 
               + playLengthInMinutes + " min, Narrador: " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        
        Book b1 = new Book("Java: How to Program", 2017, "Deitel & Deitel");
        PrintBook pb1 = new PrintBook("Java: How to Program", 2017, "Deitel & Deitel", "Pearson", "978-0-13-474335-6");
        AudioBook ab1 = new AudioBook("Java: How to Program (Audio)", 2017, "Deitel & Deitel", 750.5, 1200, "John Smith");

        
        System.out.println(b1);
        System.out.println(pb1);
        System.out.println(ab1);
    }
}
