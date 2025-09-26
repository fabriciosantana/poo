/**
 * A classe PrintBook herda de Book e representa um livro impresso.
 * Adiciona atributos específicos como editora e ISBN.
 */
public class PrintBook extends Book {
    // Atributos específicos de um livro impresso
    private String publisher;
    private String isbn;

    /**
     * Construtor para inicializar um objeto PrintBook.
     *
     * @param title     O título do livro.
     * @param year      O ano de publicação.
     * @param author    O autor do livro.
     * @param publisher A editora do livro.
     * @param isbn      O código ISBN do livro.
     */
    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        // A primeira linha DEVE ser a chamada ao construtor da superclasse (Book)
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    /**
     * Sobrescreve o método toString() para incluir os detalhes do livro impresso.
     * Reutiliza o toString() da classe pai (Book) para obter as informações básicas.
     *
     * @return Uma String formatada com todos os detalhes do livro impresso.
     */
    @Override
    public String toString() {
        return String.format("%s, Editora: %s, ISBN: %s", 
                             super.toString(), this.publisher, this.isbn);
    }
}