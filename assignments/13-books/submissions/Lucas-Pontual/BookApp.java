class Book {
    protected String title;
    protected int year;
    protected String author;
    
    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }
    
    public String toString() {
        return "Titulo: " + title + "\nAutor: " + author + "\nAno: " + year;
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
    
    public String toString() {
        return super.toString() + "\nEditora: " + publisher + "\nISBN: " + isbn;
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
    
    public String toString() {
        return super.toString() + "\nTamanho: " + fileSizeInMB + " MB\nDuracao: " + playLengthInMinutes + " minutos\nNarrador: " + narrator;
    }
}

public class BookSystem {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LIVROS ===\n");
        
        Book livro1 = new Book("1984", 1949, "George Orwell");
        
        PrintBook livro2 = new PrintBook("Java Como Programar", 2017, "Paul Deitel", "Pearson", "978-0-13-474335-6");
        
        AudioBook livro3 = new AudioBook("O Hobbit", 1937, "J.R.R. Tolkien", 245.5, 720, "Fernanda Montenegro");
        
        System.out.println("1. LIVRO GENERICO:");
        System.out.println(livro1.toString());
        System.out.println();
        
        System.out.println("2. LIVRO IMPRESSO:");
        System.out.println(livro2.toString());
        System.out.println();
        
        System.out.println("3. AUDIOLIVRO:");
        System.out.println(livro3.toString());
        System.out.println();
        
        System.out.println("4. USANDO POLIMORFISMO:");
        Book[] biblioteca = {livro1, livro2, livro3};
        
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("Livro " + (i + 1) + ":");
            System.out.println(biblioteca[i].toString());
            System.out.println();
        }
    }
}
