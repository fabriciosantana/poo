public class BookApp {
    public static void main(String[] args) {
        // tipo declarado Book: cada chamada de toString() executa a versao da classe real do objeto
        Book book = new Book("Dom Casmurro", 1899, "Machado de Assis");
        Book printBook = new PrintBook("Java: How to Program, Early Objects", 2017, "Paul Deitel",
                "Pearson", "978-0-13-474335-6");
        Book audioBook = new AudioBook("O Pequeno Príncipe", 1943, "Antoine de Saint-Exupéry",
                85.5, 92, "Ana Ribeiro");

        System.out.println(book.toString());
        System.out.println(printBook.toString());
        System.out.println(audioBook.toString());
    }
}
