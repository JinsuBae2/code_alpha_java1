package course4.ruleofbiodome08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private LocalDate publishedDate;
    private boolean available;
    private LocalDate lastBorrowedDate;

    public Book(String title, String author, LocalDate publishedDate) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.available = true;
        this.lastBorrowedDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDate getLastBorrowedDate() {
        return lastBorrowedDate;
    }

    public void borrow() {
        available = false;
        lastBorrowedDate = LocalDate.now();
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        String borrowed = available ? "가능" : "불가능";
        String borrowedDate = lastBorrowedDate == null ? "N/A" : lastBorrowedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "제목: \"" + title + "\", 저자: \"" + author + "\", 출판일: \"" + publishedDate + "\", 대출 가능 여부: \"" +
                borrowed + "\", 최근 대출 날짜: \"" + borrowedDate + "\"";
    }

    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareTo(other.getTitle());
    }
}
