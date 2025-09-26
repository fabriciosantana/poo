// File: BookApp.java

public class BookApp {
    public static void main(String[] args) {
        // 1. Instanciando um objeto da classe base Book
        System.out.println("--- Livro Genérico ---");
        Book genericBook = new Book("O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979);
        System.out.println(genericBook); // O método toString() é chamado automaticamente
        System.out.println(); // Linha em branco para separar

        // 2. Instanciando um objeto da subclasse PrintBook
        System.out.println("--- Livro Impresso ---");
        PrintBook printedBook = new PrintBook(
            "Java: Como Programar", 
            "Paul Deitel & Harvey Deitel", 
            2017, 
            "Pearson", 
            "978-0134743356"
        );
        System.out.println(printedBook);
        System.out.println();

        // 3. Instanciando um objeto da subclasse AudioBook
        System.out.println("--- Audiolivro ---");
        AudioBook audioBook = new AudioBook(
            "Duna", 
            "Frank Herbert", 
            1965, 
            325.5, 
            1260, 
            "Scott Brick"
        );
        System.out.println(audioBook);
    }
}