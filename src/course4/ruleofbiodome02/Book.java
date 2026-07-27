package course4.ruleofbiodome02;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void bookBorrow() {
        this.isBorrowed = true;
    }

    public void bookReturn() {
        this.isBorrowed = false;
    }

    public void displayInfo() {
        System.out.println("제목 : " + this.getTitle() + ", 저자 : " + getAuthor());
    }
}
