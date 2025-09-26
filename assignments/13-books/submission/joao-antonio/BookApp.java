class Book {
    private String title;
    private int year;
    private String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Título: " + title + "\n" +
               "Autor: " + author + "\n" +
               "Ano de Publicação: " + year;
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

    public String getPublisher() { return publisher; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Editora: " + publisher + "\n" +
               "ISBN: " + isbn;
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

    public double getFileSizeInMB() { return fileSizeInMB; }
    public int getPlayLengthInMinutes() { return playLengthInMinutes; }
    public String getNarrator() { return narrator; }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Tamanho do Arquivo (MB): " + fileSizeInMB + "\n" +
               "Duração (Minutos): " + playLengthInMinutes + "\n" +
               "Narrador: " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("O Guia do Mochileiro das Galáxias", 1979, "Douglas Adams");

        PrintBook printedBook = new PrintBook(
            "O Senhor dos Anéis",
            1954,
            "J.R.R. Tolkien",
            "HarperCollins",
            "978-0618640157"
        );

        AudioBook audioBook = new AudioBook(
            "Duna",
            1965,
            "Frank Herbert",
            225.5,
            1260,
            "Cid Moreira (Exemplo)"
        );
        System.out.println("--- Informações do Livro Genérico ---");
        System.out.println(genericBook.toString());
        System.out.println();

        System.out.println("--- Informações do Livro Impresso ---");
        System.out.println(printedBook.toString());
        System.out.println();

        System.out.println("--- Informações do Audiolivro ---");
        System.out.println(audioBook.toString());
    }
}