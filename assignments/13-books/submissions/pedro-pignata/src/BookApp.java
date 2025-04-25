import java.util.Scanner;

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
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

// Subclasse PrintBook
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
        return super.toString() + ", Publisher: " + publisher + ", ISBN: " + isbn;
    }
}

// Subclasse AudioBook
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
        return super.toString() + ", File Size: " + fileSizeInMB + "MB, Play Length: " + playLengthInMinutes + " minutes, Narrator: " + narrator;
    }
}

// Classe principal BookApp
public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("Generic Book", 2020, "John Doe");
        PrintBook printBook = new PrintBook("Printed Book", 2019, "Jane Smith", "Pearson", "978-0134743356");
        AudioBook audioBook = new AudioBook("Audio Book", 2021, "Alice Brown", 150.5, 360, "Bob Narrator");

        System.out.println(genericBook);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}