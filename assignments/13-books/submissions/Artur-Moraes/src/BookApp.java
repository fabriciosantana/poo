import java.util.ArrayList;
import java.util.List;
public class BookApp {
    public static void main(String[] args) {
        // Lista de livros genérica
        List<Book> books = new ArrayList<>();
        
        // Adicionando diferentes tipos de livros
        books.add(new Book("Livro Genérico", 2000, "Autor Desconhecido"));
        books.add(new PrintBook("Livro Impresso", 2010, "Autor A", "Editora X", "123-456-789"));
        books.add(new AudioBook("Audiolivro", 2022, "Autor B", 350.0, 720, "Narrador Y"));
        
        // Exibindo informações dos livros
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
