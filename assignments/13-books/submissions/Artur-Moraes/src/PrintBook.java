// Subclasse que representa um livro impresso
class PrintBook extends Book {
    private String publisher;
    private String isbn;

    // Construtor que inicializa atributos do livro impresso
    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Sobrescreve toString para incluir editora e ISBN
    @Override
    public String toString() {
        return super.toString() + ", Editora: " + publisher + ", ISBN: " + isbn;
    }
}