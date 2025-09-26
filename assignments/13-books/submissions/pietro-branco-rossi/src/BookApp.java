// ---- CLASSE PAI BOOK ---- //
class Book {
    private String title;
    private int year;
    private String author;

    // Construtor de Book
    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    // Sobrescreve o método toString
    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Ano: %d", title, author, year);
    }
}

// ---- SUBCLASSE PRINTBOOK ---- //
class PrintBook extends Book {
    private String publisher;
    private String isbn;

    // Construtor da subclasse
    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        // Inicializa os atributos específicos desta classe
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Sobrescreve o toString, aproveitando o da classe-pai e adicionando novas informações
    @Override
    public String toString() {
        return super.toString() +
               String.format(" | Editora: %s | ISBN: %s", publisher, isbn);
    }
}

// ---- SUBCLASSE AUDIOBOOK ---- //
class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    // Construtor da subclasse
    public AudioBook(String title, int year, String author,
                     double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        // Inicializa os atributos específicos desta classe
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    // Sobrescreve o toString, aproveitando o da classe-pai e adicionando novas informações
    @Override
    public String toString() {
        return super.toString() +
               String.format(" | Tamanho: %.1fMB | Duração: %dmin | Narrador: %s",
                             fileSizeInMB, playLengthInMinutes, narrator);
    }
}

// ---- CLASSE DE EXECUÇÃO BOOKAPP  ---- //
public class BookApp {
    public static void main(String[] args) {
        
        Book generic = new Book("Vagabond (Conceito)", 1999, "Takehiko Inoue");
        

        PrintBook printed = new PrintBook("Vagabond", 1999, "Takehiko Inoue",
                                          "Panini", "078-85-426-0365-1");
                                          
        AudioBook audio = new AudioBook("Vagabond (Audio Drama)", 1999, "Takehiko Inoue",
                                        350.8, 650, "Guilherme Briggs");

        // ---- Imprimindo as informações no console ---- //
        System.out.println("--- Livro Genérico ---");
        System.out.println(generic);
        System.out.println("\n--- Mangá Impresso ---");
        System.out.println(printed);
        System.out.println("\n--- Audiolivro (Hipotético) ---");
        System.out.println(audio);
    }
}