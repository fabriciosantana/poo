// Superclasse 
public class Book {

    protected String title; // titulo do livro
    protected int year; // ano de publicação
    protected String author; // nome do autor

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    // Método principal (main) 
    public static void main(String[] args) {
        
        // instanciando as classes
        Book livroGenerico = new Book("Programação Orientada a Objetos", 2023, "Autor Desconhecido");
        PrintBook livroImpresso = new PrintBook("O Senhor dos Anéis", 1954, "J.R.R. Tolkien", "HarperCollins", "978-8595084742");
        AudioBook livroAudio = new AudioBook("O Hobbit", 1937, "J.R.R. Tolkien", 450.5, 600, "Mauro Ramos");

        
        System.out.println("--- Lista de Livros ---");
        System.out.println(livroGenerico.toString());
        System.out.println(livroImpresso.toString());
        System.out.println(livroAudio.toString());
    }

    // metodo para exibir infos da classe base
    @Override
    public String toString() {
        return String.format("Título: %s. Ano de publicação: %d. Autor: %s", getTitle(), getYear(), getAuthor());
    }

    // metodos get/set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Subclasse PrintBook 
class PrintBook extends Book {

    private String publisher; // editora do livro
    private String isbn; // cod. ISBN do livro

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("%s. Editora do livro: %s. ISBN: %s", super.toString(), getPublisher(), getIsbn());
    }

    public String getPublisher() {
        return publisher;
    }

    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

// Subclasse AudioBook 
class AudioBook extends Book {

    private double fileSizeInMB; // Tamanho do arquivo em megabytes
    private int playLengthInMinutes; // duracao em minutos do áudio
    private String narrator; // nome do narrador

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return String.format("%s. Tamanho do arquivo em MB: %.2f. Duracao do audio em minutos: %d. Nome do narrador: %s", 
               super.toString(), getFileSizeMb(), getPlayLengthInMinutes(), getNarrator());
    }

    
    public double getFileSizeMb() {
        return fileSizeInMB;
    }

    
    public void setFileSizeMb(double fileSizeInMB) {
        this.fileSizeInMB = fileSizeInMB;
    }

    public int getPlayLengthInMinutes() {
        return playLengthInMinutes;
    }

    
    public void setPlayLengthInMinutes(int playLengthInMinutes) {
        this.playLengthInMinutes = playLengthInMinutes;
    }

    
    public String getNarrator() {
        return narrator;
    }

  
    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }
}