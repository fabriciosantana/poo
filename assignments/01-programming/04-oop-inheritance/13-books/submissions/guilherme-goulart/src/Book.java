public class Book {
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
        return String.format("Title: '%s', Year: %d, Author: '%s'", title, year, author);
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
        return String.format("%s, Publisher: %s, ISBN: %s", super.toString(), publisher, isbn);
    }
}

class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLenghtInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLenghtInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLenghtInMinutes = playLenghtInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return String.format("%s, File Size: %.2f MB, Play Length: %d minutes, Narrator: %s", super.toString(), fileSizeInMB, playLenghtInMinutes, narrator);
    }
}