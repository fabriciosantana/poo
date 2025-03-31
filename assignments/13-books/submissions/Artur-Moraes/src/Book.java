// Classe base que representa um livro genérico
class Book {
    protected String title;
    protected int year;
    protected String author;

    // Construtor para inicializar os atributos do livro
    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    // Método toString sobrescrito para exibir as informações do livro
    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author + ", Ano: " + year;
    }
}
