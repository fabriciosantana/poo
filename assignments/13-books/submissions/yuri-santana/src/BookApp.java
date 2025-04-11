
public class BookApp {
  public static void main(String[] args) {   
    Book book1 = new Book("a sutil arte de dar o fodasse", 2000, "Pedro dutra");
    Book book2 = new Book("o homem mais inteligente que ja existiu", 1989, "Pignight");
    AudioBook audioBook = new AudioBook("Como render nos estudos tutorial facil e rapido", 2025, "Rafael lopes dias", 20, 5, "Rafael Lopes Dias");
    PrintBook printBook = new PrintBook("cachorro gato", 1200, "mc pipokinha", "Kondzilla", "1111");
    System.out.println(book1);
    System.out.println(book2);
    System.out.println(audioBook);
    System.out.println(printBook);
  }
}
