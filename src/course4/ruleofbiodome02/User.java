package course4.ruleofbiodome02;

import java.util.ArrayList;
import java.util.List;

abstract class User {
    private int userId;
    private String name;
    private List<Book> bookList;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            bookList.add(book);
            book.bookBorrow();
        }
    }

    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            bookList.remove(book);
            book.bookReturn();
        }
    }
}
