
public class BookApp {
    public static void main(String[] args) {
        System.out.println("--- Demonstração da Hierarquia de Livros ---");

        
        Book genericBook = new Book("O Guia do Mochileiro das Galáxias", 1979, "Douglas Adams");

        
        PrintBook printedBook = new PrintBook("Duna", 1965, "Frank Herbert", "Editora Aleph", "978-8576572633");

        
        AudioBook audioBook = new AudioBook("O Hobbit", 1937, "J.R.R. Tolkien", 350.5, 675, "Andy Serkis");

        System.out.println("\n--- Informações dos Livros ---");

        System.out.println("\n[Livro Genérico]");
        
        System.out.println(genericBook);

        System.out.println("\n[Livro Impresso]");
        System.out.println(printedBook);

        System.out.println("\n[Audiolivro]");
        System.out.println(audioBook);
    }
}