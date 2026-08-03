package course4.ruleofbiodome08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
        System.out.println("도서관 시스템이 생성되었습니다.");
    }

    public void add(Book book) {
        books.add(book);
        System.out.println("\"" + book.getTitle() + "\"가 도서 목록에 추가되었습니다.");
    }

    private Book find(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrow(String title) {
        Book book = find(title);
        if (book == null) {
            System.out.println("\"" + title + "\"은 도서 목록에 없습니다.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("\"" + title + "\"은 이미 대출 중입니다.");
            return;
        }

        book.borrow();
        System.out.println("\"" + book.getTitle() + "\" 대출되었습니다. 최근 대출 날짜 업데이트: "
                + book.getLastBorrowedDate());
    }

    public void returnBook(String title) {
        Book book = find(title);
        if (book == null) {
            System.out.println("\"" + title + "\"은 도서 목록에 없습니다.");
            return;
        }

        book.returnBook();
        System.out.println("\"" + book.getTitle() + "\" 반납되었습니다.");
    }

    public void show() {
        List<Book> sortBooks = new ArrayList<>(books);
        Collections.sort(sortBooks);
        sortBooks.forEach(System.out::println);
    }

    public void showBy(Comparator<Book> sort) {
        List<Book> sortBooks = new ArrayList<>(books);
        sortBooks.sort(sort);
        sortBooks.forEach(System.out::println);
    }

    public void showRecent() {
        showBy(new BorrowSort());
    }

    public void show(String title) {
        Book book = find(title);

        if (book == null) {
            System.out.println("\"" + title + "\"은 도서 목록에 없습니다.");
            return;
        }

        System.out.println(book);
    }
}
