import java.util.Scanner;

public class Book {
    public String title;
    public int year;
    public String author;

    public Book (String titleBook, int yearBook, String authorBook) {
        this.title = titleBook;
        this.year = yearBook;
        this.author = authorBook;
    }

    public String toString() {
        return "Título: " + titleBook + "\n" + "Autor: " + authorBook + "\n" + "Ano: " + yearBook;
    }
}

public static PrintBook extends Book {
    public String publisher;
    public String isbn;

    public Book (String publisherBook, String isbnBook) {
        this.publisher = publisherBook;
        this.isbn = isbnBook;
    }

    public String toString() {
        return super.toString() + "\n" + "Editora: " + publisherBook + "\n" + "ISBN: " + isbnBook;
    }
}

public static AudioBook extends Book {
    public double fileSizeInMB;
    public int playLengthInMinutes;
    public String narrator;

    public Book (double fileSizeInMBBook, int playLengthInMinutesBook, String narratorBook) {
        this.fileSizeInMB = fileSizeInMBBook;
        this.playLengthInMinutes = playLengthInMinutesBook;
        this.narrator = narratorBook;
    }

    public String toString() {
        return super.toString() + "\n" + "Tamanho: " + fileSizeInMBBook + "\n" + "Narrador: " + narratorBook + "\n" + "Duração: " + playLengthInMinutesBook + "min";
    }
}
