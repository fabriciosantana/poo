class Book {
  protected String title;
  protected int year;
  protected String author;

  public Book() {}

  public Book(String title, int year, String author) {
    this.author = author;
    this.title = title;
    this.year = year;
  }

  @Override
  public String toString() {
    return String.format(
      "\nTitle: %s\nAuthor: %s\nYear: %d",
      this.title,
      this.author,
      this.year
    );
  }
}

class PrintBook extends Book {
  String publisher;
  String isbn;

  public PrintBook(/*Book book, */String publisher, String isbn) {
    // super(book.title, book.year, book.author);
    super();
    this.publisher = publisher;
    this.isbn = isbn;
  }

  public void setBook(Book book) {
    this.title = book.title;
    this.author = book.author;
    this.year = book.year;
  }

  @Override
  public String toString() {
    if (this.title == null || this.title.isEmpty()) {
      throw new Error("Define the book entity correctly, use the setBook method.");
    }

    return String.format(
      "%s\nPublisher: %s\nISBN: %s",
      super.toString(),
      this.publisher,
      this.isbn);
  }
}

class AudioBook extends Book {
  double fileSizeInMB;
  int playLengthInMinutes;
  String narrator;

  public AudioBook(Book book, double fileSizeInMB, int playLengthInMinutes, String narrator) {
    super(book.title, book.year, book.author);

    this.fileSizeInMB = fileSizeInMB;
    this.playLengthInMinutes = playLengthInMinutes;
    this.narrator = narrator;
  }

  @Override
  public String toString() {
    return String.format(
      "%s\nNarrator: %s\nMinutes: %d\nSize: %.2f",
      super.toString(),
      this.narrator,
      this.playLengthInMinutes,
      this.fileSizeInMB);
  }
}

public class BookApp {
  public static void main(String[] args) {
    Book book = new Book("Como Mentir com Estatística", 1954, "Darrell Huff");

    PrintBook printVersion = new PrintBook("Intrínseca", "978-85-8057-052-6");
    printVersion.setBook(book);

    AudioBook audioVersion = new AudioBook(book, 150.5, 240, "Carlos Voltor");

    System.out.println(book); // Unnecessary 'toString()' call
    System.out.println(printVersion); // Unnecessary 'toString()' call
    System.out.println(audioVersion); // Unnecessary 'toString()' call
  }
}
