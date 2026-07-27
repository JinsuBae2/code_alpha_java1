package course4.ruleofbiodome02;

public class Manager extends User implements BookManageable{
    public Manager(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void addBook(Book book, Library library) {
        library.addBook(this, book);
    }

    @Override
    public void removeBook(Book book, Library library) {
        library.removeBook(book);
    }
}
