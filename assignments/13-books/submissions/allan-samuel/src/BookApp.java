/* Nome: Allan Samuel Alves do Monte
   Matrícula: 24101279  */
   
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
        return super.toString() + ", Editora: " + publisher + ", ISBN: " + isbn;
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
        return super.toString() + ", Tamanho do arquivo: " + fileSizeInMB + "MB, Duração: " + playLengthInMinutes + " min, Narrador: " + narrator;
    }
}

// Classe principal BookApp
public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("Java Programming", 2017, "Paul Deitel");
        PrintBook printBook = new PrintBook("Effective Java", 2018, "Joshua Bloch", "Pearson", "978-0134685991");
        AudioBook audioBook = new AudioBook("Clean Code", 2008, "Robert C. Martin", 250.5, 600, "John Doe");

        System.out.println(genericBook);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}
