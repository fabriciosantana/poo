public class BookApp {
    public static void main(String[] args) {
        Book b = new Book("Dom Casmurro", 1899, "Machado de Assis");
        PrintBook pb = new PrintBook("O Cortiço", 1890, "Aluísio Azevedo", "B. L. Garnier", "978-85-01-01234-5");
        AudioBook ab = new AudioBook("Memórias Próximas", 1881, "Machado de Assis", 15.5, 420, "Voz Fictícia");

        System.out.println(b);
        System.out.println(pb);
        System.out.println(ab);
    }
}
