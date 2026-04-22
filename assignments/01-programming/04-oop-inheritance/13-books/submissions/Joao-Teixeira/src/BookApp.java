public class BookApp {
    public static void main(String[] args) {
        Book livroGenerico = new Book("Dom Quixote", 1605, "Miguel de Cervantes");
        PrintBook livroImpresso = new PrintBook("O Alquimista", 1988, "Paulo Coelho", "Rocco", "978-85-325-1033-4");
        AudioBook audioLivro = new AudioBook("A Arte da Guerra", -500, "Sun Tzu", 45.5, 320, "Milton Leite");

        System.out.println(livroGenerico.toString());
        System.out.println(livroImpresso.toString());
        System.out.println(audioLivro.toString());
    }
}
