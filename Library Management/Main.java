public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("1984", "George Orwell"));

        // Show all books
        library.showBooks();

        // Issue a book
        library.issueBook("1984");

        // Try issuing same book again
        library.issueBook("1984");

        // Return book
        library.returnBook("1984");

        // Show final status
        library.showBooks();
    }
}
