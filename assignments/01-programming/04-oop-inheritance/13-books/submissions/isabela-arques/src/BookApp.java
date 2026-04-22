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
        return String.format("Título: %s%nAutor: %s%nAno: %d", 
                             title, author, year);
    }
}

class PrintBook extends Book {
    private String publisher;  
    private String isbn;       

    
    public PrintBook(String title, int year, String author, 
                     String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }


    @Override
    public String toString() {
        return super.toString() + 
               String.format("%nEditora: %s%nISBN: %s", publisher, isbn);
    }
}

class AudioBook extends Book {
    private double fileSizeInMB;       
    private int playLengthInMinutes;   
    private String narrator;           

    
    public AudioBook(String title, int year, String author,
                     double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    
    @Override
    public String toString() {
        return super.toString() + 
               String.format("%nTamanho do arquivo: %.2f MB%nDuração: %d minutos%nNarrador: %s", 
                             fileSizeInMB, playLengthInMinutes, narrator);
    }
}

public class BookApp {
    public static void main(String[] args) {
        
        Book livroGenerico = new Book(
            "O Grande Gatsby", 
            1925, 
            "F. Scott Fitzgerald"
        );

       
        PrintBook livroImpresso = new PrintBook(
            "Java: How to Program, Early Objects", 
            2017, 
            "Paul Deitel and Harvey Deitel", 
            "Pearson", 
            "978-0-13-474335-6"
        );

       
        AudioBook livroAudio = new AudioBook(
            "Project Hail Mary", 
            2021, 
            "Andy Weir", 
            320.5, 
            480, 
            "Ray Porter"
        );

        
        System.out.println("=== Livro Genérico (classe Book) ===");
        System.out.println(livroGenerico);
        System.out.println();

        System.out.println("=== Livro Impresso (classe PrintBook) ===");
        System.out.println(livroImpresso);
        System.out.println();

        System.out.println("=== Audiolivro (classe AudioBook) ===");
        System.out.println(livroAudio);
        System.out.println();

        
        System.out.println("=== Demonstração de Polimorfismo com Array ===");
        Book[] biblioteca = {livroGenerico, livroImpresso, livroAudio};
        for (Book livro : biblioteca) {
            System.out.println(livro);
            System.out.println("-----------------------------------");
        }
    }
}