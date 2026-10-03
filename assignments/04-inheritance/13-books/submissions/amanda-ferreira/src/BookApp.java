public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("An Introduction to Object-Oriented Programming", 2002, "Timothy Budd");
        Book printBook = new PrintBook(
            "Java: How to Program, Early Objects", 2017, "Paul Deitel e Harvey Deitel", "Pearson", "978-0-13-474335-6");
        Book audioBook = new AudioBook(
            "Computer Science: An Interdisciplinary Approach", 2016, "Robert Segewick e Kevin Wayne", 460.35, 1800, "Jim Dale");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}