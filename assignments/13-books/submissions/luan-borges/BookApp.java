public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("O Guia do Mochileiro das Galáxias", 1979, "Douglas Adams");

        PrintBook printBook = new PrintBook(
                "Java: How to Program, Early Objects",
                2017,
                "Paul Deitel & Harvey Deitel",
                "Pearson",
                "978-0-13-474335-6"
        );

        AudioBook audioBook = new AudioBook(
                "Duna",
                1965,
                "Frank Herbert",
                450.5,
                1260,
                "Simon Vance"
        );

        System.out.println("--- Livro Genérico ---");
        System.out.println(genericBook.toString());
        System.out.println();

        System.out.println("--- Livro Impresso ---");
        System.out.println(printBook.toString());
        System.out.println();

        System.out.println("--- Audiolivro ---");
        System.out.println(audioBook.toString());
    }
}