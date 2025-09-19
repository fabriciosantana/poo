public class BookApp {
    public static void main(String[] args) {
        Book livro = new Book("O Hobbit", 1937, "J.R.R. Tolkien");
        PrintBook printedBook = new PrintBook("Tecnofeudalismo", 2025, "Yanis Varoufakis", "Editora Crítica", "8542233190");
        AudioBook audioBook = new AudioBook("Sapiens: Uma Breve História da Humanidade", 2014, "Yuval Noah Harari", 256.5, 1068, "Antonio Fagundes");

        System.out.println(livro);
        System.out.println(printedBook);
        System.out.println(audioBook);
    }
}
